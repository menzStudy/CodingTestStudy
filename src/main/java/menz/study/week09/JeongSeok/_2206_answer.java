package menz.study.week09.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class FireLoc {
	int x;
	int y;
	int count;
	boolean destroyed;

	public FireLoc(int x, int y, int count, boolean destroyed) {
		this.x = x;
		this.y = y;
		this.count = count;
		this.destroyed = destroyed;
	}

}

public class _2206_answer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int dx[] = new int[]{1, 0, -1, 0};
		int dy[] = new int[]{0, 1, 0, -1};

		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[N][M][2];

		Queue<FireLoc> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String[] lines = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(lines[j]);
			}
		}

		queue.add(new FireLoc(0, 0, 1, false));

		while (!queue.isEmpty()) {
			FireLoc cur = queue.poll();

			if (cur.x == N - 1 && cur.y == M - 1) {
				System.out.println(cur.count);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				int nextCount = cur.count + 1;

				if (map[nx][ny] == 0) { // 벽이 아니면
					if (!cur.destroyed && !visited[nx][ny][0]) {
						queue.add(new FireLoc(nx, ny, nextCount, false));
						visited[nx][ny][0] = true;
					} else if (cur.destroyed && !visited[nx][ny][1]) {
						queue.add(new FireLoc(nx, ny, nextCount, true));
						visited[nx][ny][1] = true;
					}

				} else { // 벽이면
					if (!cur.destroyed) {
						queue.add(new FireLoc(nx, ny, nextCount, true));
						visited[nx][ny][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
