package menz.study.week09.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int length;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, int length) {
		this.x = x;
		this.y = y;
		this.length = length;
	}
}

public class _2146_ {

	static int N, group_idx;
	static int min = Integer.MAX_VALUE;
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};

	static int[][] map;
	static boolean[][] visited;

	static final int OCEAN = 0;
	static final int LAND = 1;

	private static void findIsland(int i, int j) {
		group_idx++;

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j));
		visited[i][j] = true;
		map[i][j] = group_idx;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (map[nx][ny] == OCEAN || visited[nx][ny]) {
					continue;
				}

				queue.add(new Point(nx, ny));
				visited[nx][ny] = true;
				map[nx][ny] = group_idx;
			}
		}
	}

	private static void calculateMinDistance(int i, int j, int group_idx) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j, 0));
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (map[nx][ny] == group_idx || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] == OCEAN) {
					queue.add(new Point(nx, ny, now.length + 1));
					visited[nx][ny] = true;
				} else {
					min = Math.min(min, now.length);
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 입력 초기화
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2. 섬 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == OCEAN || visited[i][j]) {
					continue;
				}
				findIsland(i, j);
			}
		}


		// 3. 최단거리 찾기
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == OCEAN || visited[i][j]) {
					continue;
				}

				calculateMinDistance(i, j, map[i][j]);
				visited = new boolean[N][N];
			}
		}

		System.out.println(min);
	}

}
