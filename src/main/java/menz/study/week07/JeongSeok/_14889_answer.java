package menz.study.week07.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889_answer {

	static int N;
	static int[][] map;
	static boolean[] selected;
	static int min = Integer.MAX_VALUE;

	private static void rec_func(int idx, int k) {
		if (k == N / 2) {
			calculate();
		} else {
			for (int i = idx; i < N; i++) {
				if (!selected[i]) {
					selected[i] = true;
					rec_func(i + 1, k + 1);
					selected[i] = false;
				}
			}
		}
	}

	private static void calculate() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (selected[i] == true && selected[j] == true) {
					start += map[i][j];
					start += map[j][i];
				} else if (selected[i] == false && selected[j] == false) {
					link += map[i][j];
					link += map[j][i];
				}
			}
		}

		int value = Math.abs(start - link);

		if (value == 0) {
			System.out.println(0);
			System.exit(0);
		}

		min = Math.min(value, min);
	}

	public static void main(String[] args) throws IOException {
		input();

		rec_func(0, 0);
		System.out.println(min);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		selected = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
