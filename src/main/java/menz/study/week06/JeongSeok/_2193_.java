package menz.study.week06.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2193_ {
	/**
	 * int형 배열을 선언할 경우 입력의 최대치인 90이 들어왔을 때 int의 범위를 벗어나게 됨
	 */
	static long[] dp = new long[91];

	static void init() {

		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= 90; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init();
		System.out.println(dp[Integer.parseInt(br.readLine())]);
	}
}
