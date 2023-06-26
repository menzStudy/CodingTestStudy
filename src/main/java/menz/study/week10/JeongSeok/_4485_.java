package menz.study.week10.JeongSeok;

import java.io.*;
import java.util.*;

class Zelda {
	int x;
	int y;
	int rupee;

	public Zelda(int x, int y, int rupee) {
		this.x = x;
		this.y = y;
		this.rupee = rupee;
	}
}

public class _4485_ {

	static int N, result;
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static int[][] map, dist;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			map = new int[N][N];
			dist = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			bfs();
			sb.append("Problem ").append(count).append(": ").append(dist[N - 1][N - 1]).append("\n");
			count++;
		}

		System.out.println(sb);
	}

	private static void bfs() {
		PriorityQueue<Zelda> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.rupee));
		queue.offer(new Zelda(0, 0, map[0][0]));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Zelda now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (!visited[nx][ny] && dist[nx][ny] > now.rupee + map[nx][ny]) {
					dist[nx][ny] = now.rupee + map[nx][ny];
					visited[nx][ny] = true;
					queue.offer(new Zelda(nx, ny, dist[nx][ny]));
				}
			}
		}
	}
}