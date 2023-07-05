package menz.study.week10.JeongSeok;

import java.io.*;
import java.util.*;

public class _9370_ {

	private static final int INF = Integer.MAX_VALUE;

	private static int T, n, m, t, s, g, h;
	private static ArrayList<Node> graph[];
	private static boolean visited[];
	private static int dist[];
	private static int candidate[];
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			// 목적지별 최단 경로를 저장할 ArrayList
			ArrayList<Integer> list = new ArrayList<>();

			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n + 1];
			visited = new boolean[n + 1];
			dist = new int[n + 1];
			candidate = new int[t];

			st = new StringTokenizer(br.readLine());

			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			// 그래프 초기화, 거리 배열 초기화
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
				dist[i] = INF;
			}

			// 그래프 입력
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				// 양방향 도로
				graph[a].add(new Node(b, d));
				graph[b].add(new Node(a, d));
			}

			// 목적지 후보 입력
			for (int i = 0; i < t; i++) {
				candidate[i] = Integer.parseInt(br.readLine());
			}



			for (int i = 0; i < t; i++) {

				// 출발지 -> 목적지 최단 경로
				int result1 = dijkstra(s, candidate[i]);

				// 출발지 -> g -> h -> 목적지 최단 경로
				int result2 = dijkstra(s, g);
				result2 += dijkstra(g, h);
				result2 += dijkstra(h, candidate[i]);

				// 출발지 -> h -> g -> 목적지 최단 경로
				int result3 = dijkstra(s, h);
				result3 += dijkstra(h, g);
				result3 += dijkstra(g, candidate[i]);

				if (result1 == result2) {
					list.add(candidate[i]);
				}

				if (result1 == result3) {
					list.add(candidate[i]);
				}
			}

			list.sort(null);

			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}

			System.out.println();
		}

	}

	private static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		pq.add(new Node(start, 0));
		visited = new boolean[n + 1];
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (!visited[now.v]) {
				visited[now.v] = true;
			}

			for (Node next : graph[now.v]) {
				if (!visited[next.v] && dist[next.v] > now.cost + next.cost) {
					dist[next.v] = now.cost + next.cost;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		return dist[end];
	}
}
