package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_ {

	static int[][] dp = new int[41][2];

	public static int[] fibo(int n) {
		if (dp[n][0] == -1 || dp[n][1] == -1) {

			dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
			dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];

		}
		return dp[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < 41; i++) {
			for (int j = 0; j < 2; j++) {
				dp[i][j] = -1;
			}
		}

		// 0일때 0의 갯수
		dp[0][0] = 1;

		// 0일때 1의 갯수
		dp[0][1] = 0;

		// 1일때 0의 갯수
		dp[1][0] = 0;

		// 1일때 1의 갯수
		dp[1][1] = 1;

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			fibo(N);
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}

}
