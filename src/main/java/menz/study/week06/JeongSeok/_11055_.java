package menz.study.week06.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11055_ {

	/**
	 *
	 * 지금까지 만들어 놓은 증가수열이 a[i] 보다 작아야 하며, 마지막 수가 a[i]보다 작아야 한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[] arr = new int[T];
		int[] dp = new int[T];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 지금까지 만들어 놓은 증가수열 a[i](j < i)보다 작고, 마지막 수가 a[i]보다 작은 경우에다가 합만 더해주자
		for (int i = 0; i < T; i++) {
			dp[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < T; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}

		System.out.println(max);
	}
}
