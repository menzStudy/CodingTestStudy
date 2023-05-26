package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_ {

	static int MAX_LENGTH = 10;
	static int[] dp = new int[MAX_LENGTH + 1];

	public static void initArray() {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= MAX_LENGTH; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
	}

	public static void main(String[] args) throws IOException {
		initArray();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}

}
