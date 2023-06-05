package menz.study.week07.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11058_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];

		for (int i = 1; i <= 6; i++) {
			dp[i] = i;
		}


		for (int i = 7; i <= N; i++) {

			// 복사 & 붙여넣기 하려면 최소 3번째 전의 인덱스의 값을 *(3-1)배 해서 비교하면 된다.
			for (int j = 3; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
			}
		}

		System.out.println(dp[N]);
	}

}
