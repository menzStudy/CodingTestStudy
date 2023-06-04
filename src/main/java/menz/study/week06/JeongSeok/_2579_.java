package menz.study.week06.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_ {

	static int[] arr, dp;
	static int T;
	public static void init(BufferedReader br) throws IOException {
		T = Integer.parseInt(br.readLine());

		arr = new int[T + 1];
		dp = new int[T + 1];

		for (int i = 1; i <= T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}

	public static void printMaxValue() {
		dp[1] = arr[1];

		if (T >= 2) {
			dp[2] = arr[1] + arr[2];
		}

		for (int i = 3; i <= T; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
		}

		System.out.println(dp[T]);
	}

	public static void main(String[] args) throws IOException {
		init(new BufferedReader(new InputStreamReader(System.in)));
		printMaxValue();
	}
}
