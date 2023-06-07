package menz.study.week07.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888_answer {

	static int N, max, min;
	static int[] arr, operator, temp;
	static StringBuilder sb = new StringBuilder();

	private static int calculator() {
		int value = arr[1];

		for (int i = 1; i <= N - 1; i++) {
			if (temp[i] == 1) {
				value = value + arr[i + 1];
			}
			if (temp[i] == 2) {
				value = value - arr[i + 1];
			}
			if (temp[i] == 3) {
				value = value * arr[i + 1];
			}
			if (temp[i] == 4 ) {
				value = value / arr[i + 1];
			}
		}

		return value;
	}

	private static void dfs(int depth) {
		if (depth == N) {
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			for (int cand = 1; cand <= 4; cand++) {
				if (operator[cand] >= 1) {
					operator[cand]--;
					temp[depth] = cand;
					dfs(depth + 1);
					operator[cand]++;
					temp[depth] = 0;
				}
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		arr = new int[N + 1];
		operator = new int[5];
		temp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws IOException {
		input();

		//start
		dfs(1);
		sb.append(max).append("\n").append(min);
		System.out.println(sb.toString());
	}

}
