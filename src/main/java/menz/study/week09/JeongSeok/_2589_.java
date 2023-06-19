package menz.study.week09.JeongSeok;

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

public class _2589_ {

	static int N, M, result;
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static int[][] distance;
	static char[][] map;
	static boolean[][] visited;


	public static void main(String[] args) throws IOException {
		// 모든 육지에서 bfs 탐색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					// bfs 시작
					visited = new boolean[N][M];
					distance = new int[N][M];
					bfs(i, j);
				}
			}
		}

		System.out.println(result);
	}

	private static void bfs(int i, int j) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(i, j));
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (map[nx][ny] == 'W' || visited[nx][ny]) {
					continue;
				}

				queue.offer(new Pair(nx, ny));
				visited[nx][ny] = true;
				distance[nx][ny] = distance[cur.x][cur.y] + 1;
				result = Math.max(result, distance[nx][ny]);
			}
		}
	}

}

