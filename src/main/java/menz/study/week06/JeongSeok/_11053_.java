package menz.study.week06.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_ {

	static int[] dp, arr;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		dp = new int[T];
		arr = new int[T];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// start
		for (int i = 0; i < T; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		for (int i = 0; i < T; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}

		System.out.println(max);

	}
}
