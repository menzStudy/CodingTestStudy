package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461_failed {

	static int MAX_LENGTH = 100;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] dp = new int[MAX_LENGTH + 1];

		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= MAX_LENGTH; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
			System.out.println(i + " : " + dp[i]);
		}

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			System.out.println(dp[N]);
		}

	}

}