package menz.study.week10.JeongSeok;

import java.util.*;
import java.io.*;

class City {
	int v;
	int cost;

	public City(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}
public class _11657_answer {

	private static final int INF = Integer.MAX_VALUE;
	private static int N, M;
	private static ArrayList<City> graph[];
	private static long dist[];
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		dist = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}

		// 단방향
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new City(b, c));
		}


		if (bellmanFord()) {
			sb.append("-1\n");
		} else {
			for (int i = 2; i <= N; i++) {
				if (dist[i] == INF) {
					sb.append("-1\n");
				} else {
					sb.append(dist[i] + "\n");
				}
			}
		}

		System.out.println(sb);
	}

	private static boolean bellmanFord() {
		dist[1] = 0; // 시작점은 0으로 초기화.
		boolean update = false;

		// (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
		for (int i = 1; i < N; i++) {
			update = false;

			// 최단거리 초기화.
			for (int j = 1; j <= N; j++) {
				for (City city : graph[j]) {
					if (dist[j] == INF) {
						break;
					}

					if (dist[city.v] > dist[j] + city.cost) {
						dist[city.v] = dist[j] + city.cost;
						update = true;
					}
				}
			}

			// 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
			if (!update) {
				break;
			}
		}

		// (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
		// (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
		if (update) {
			for (int i = 1; i <= N; i++) {
				for (City city : graph[i]) {
					if (dist[i] == INF) {
						break;
					}

					if (dist[city.v] > dist[i] + city.cost) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
