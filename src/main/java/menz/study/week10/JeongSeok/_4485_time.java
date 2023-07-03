package menz.study.week10.JeongSeok;

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

public class _4485_time {

	static int N, result;
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			N = Integer.parseInt(br.readLine());
			int count = 1;

			if (N == 0) {
				System.out.println(sb);
				break;
			}

			map = new int[N][N];
			visited = new boolean[N][N];


			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs();
			sb.append("Problem ").append(count).append(": ").append(result);
			count++;
		}
	}

	private static void bfs() {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0, 0));
		visited[0][0] = true;
		result = map[0][0];

		while (!queue.isEmpty()) {
			Pair now = queue.poll();

			if (now.x == N - 1 && now.y == N - 1) {
				break;
			}

			int min = Integer.MAX_VALUE;
			int x = 0;
			int y = 0;

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] < min) {
					min = map[nx][ny];
					x = nx;
					y = ny;
				}
				visited[nx][ny] = true;
			}

			queue.offer(new Pair(x, y));
			result += min;
		}
	}

}

