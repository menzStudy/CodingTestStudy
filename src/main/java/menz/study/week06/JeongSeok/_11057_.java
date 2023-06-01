package menz.study.week06.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11057_ {

	static long[][] dp;
	static long divider = 10007;

	public static void init(int N) {
		dp = new long[N + 1][10];

		// 자릿수가 1일 때 초기값 셋팅
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		// 자릿수가 2부터 dp 시작
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= divider;
				}
			}
		}
	}

	public static void printResult(int N) {
		long result = 0;

		for (int i = 0; i < 10; i++) {
			result += dp[N][i];
		}

		System.out.println(result % divider);
	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		init(N);
		printResult(N);

	}

}
