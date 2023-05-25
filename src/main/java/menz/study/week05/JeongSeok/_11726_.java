package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726_ {

	static int MAX_LENGTH = 1000;
	static int DIVIDE_NUMBER = 10007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dp = new int[MAX_LENGTH + 1];

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= MAX_LENGTH; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % DIVIDE_NUMBER;
		}

		int N = Integer.parseInt(br.readLine());

		System.out.println(dp[N]);
	}

}
