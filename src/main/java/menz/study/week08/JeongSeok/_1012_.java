package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class _1012_ {

	static int M, N, K;
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static int[][] ground;
	static boolean[][] visited;
	static Queue<Pair> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// 1. 테스트 케이스만큼 입력을 받는다.
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			ground = new int[N][M];
			visited = new boolean[N][M];

			int count = 0;

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[y][x] = 1;
			}

			// 2. 2중 for문을 돌면서 bfs로 탐색할 수 있는 구간 찾기
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (ground[j][k] != 0 && !visited[j][k]) {
						count++;

						// 3. bfs 탐색
						bfs(j, k);
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void bfs(int j, int k) {
		queue.add(new Pair(j, k));
		visited[j][k] = true;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (ground[nx][ny] == 1 && !visited[nx][ny]) {
					queue.add(new Pair(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
}
