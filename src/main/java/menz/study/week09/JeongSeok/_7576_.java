package menz.study.week09.JeongSeok;

import java.util.*;
import java.io.*;

public class _7576_ {

	static int N, M, empty, result;
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static int[][] tomatoes, dates;
	static Queue<Pair> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		// tomatoes = dates = new int[N][M]; <-- 이런식으로 초기화 하게 되면 리턴값이 -1만 나옴 왜지..?
		tomatoes = new int[N][M];
		dates = new int[N][M];
		empty = result = 0;


		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				tomatoes[i][j] = tomato;
				// -1로 초기화를 해두면 별도의 visit 배열이 필요없음
				dates[i][j] = -1;

				if (tomato == 1) {
					queue.offer(new Pair(i, j));
					dates[i][j] = 1;
				}
				if (tomato == -1) {
					empty++;
				}
			}
		}

		bfs();
		calculateResult();
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				// 새로운 좌표값이 격자모양 안에 들어가있는지 확인
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (tomatoes[nx][ny] == -1 || dates[nx][ny] != -1) {
					continue;
				}

				queue.offer(new Pair(nx, ny));
				dates[nx][ny] = dates[cur.x][cur.y] + 1;
			}
		}
	}

	private static void calculateResult() {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dates[i][j] == -1) {
					temp++;
				} else {
					if (dates[i][j] > result) {
						result = dates[i][j];
					}
				}
			}
		}

		if (temp != empty) {
			System.out.println(-1);
		} else {
			System.out.println(result - 1);
		}
	}

}
