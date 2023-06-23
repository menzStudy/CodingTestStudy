package menz.study.week09.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014_ {

	static int F, S, G, U, D;
	static int[] arr = new int[1_000_001];
	static boolean[] visited = new boolean[1_000_001];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		queue.offer(S);
		arr[S] = 1;
		visited[S] = true;
		bfs();

		// 출발지와 도착지가 같은 경우에 대한 분기처리
		if (S == G) {
			System.out.println(0);
		} else if (arr[G] == 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(arr[G] - 1);
		}
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			int upstair = cur + U;
			int downstair = cur - D;


			if (downstair > 0 && !visited[downstair]) {
				queue.offer(downstair);
				arr[downstair] = arr[cur] + 1;
				visited[downstair] = true;
			}

			if (upstair <= F && !visited[upstair]) {
				queue.offer(upstair);
				arr[upstair] = arr[cur] + 1;
				visited[upstair] = true;
			}

		}
	}

}
