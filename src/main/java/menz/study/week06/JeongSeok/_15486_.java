package menz.study.week06.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15486_ {

	static int[] T, P, dp;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// N + 2인 이유는 index를 1부터 사용하고, 돈은 i + 1번째 받기 때문에 + 2가 됨
		T = new int[N + 2];
		P = new int[N + 2];
		dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		// start
		for (int i = 1; i < N + 2; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}

			int day = i + T[i];
			if (day < N + 2) {
				dp[day] = Math.max(dp[day], max + P[i]);
			}
		}

		System.out.println(max);
	}
}
