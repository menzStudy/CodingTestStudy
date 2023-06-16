package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2667_error {
	static int N, block, apartment;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		block = 0;

		// 1. 입력
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
			}
		}


		// 2. bfs 탐색이 가능한 곳만 찾음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0 || visited[i][j]) {
					continue;
				}
				// 3. 탐색 가능하면 바로 bfs 시작
				bfs(i, j);
			}
		}

		// 출력시 오름차순으로 정렬하지 않고 출력하여 오류발생!!!!!!
		System.out.println(block);
		System.out.print(sb);
	}

	public static void bfs(int i, int j) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(i, j));
		visited[i][j] = true;
		block++;
		apartment = 0;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			apartment++;

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (arr[nx][ny] == 1 && !visited[nx][ny]) {
					queue.add(new Pair(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		sb.append(apartment).append("\n");
	}
}
