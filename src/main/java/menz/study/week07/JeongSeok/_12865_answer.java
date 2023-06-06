package menz.study.week07.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865_answer {

	static int[][] dp;
	static int[] w;
	static int[] v;

	private static int knapsack(int i, int k) {
		// i가 0미만, 즉 범위 밖이 된다면
		if (i < 0)
			return 0;

		// 탐색하지 않은 위치라면?
		if (dp[i][k] == 0) {

			// 현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색)
			if(w[i] > k) {
				dp[i][k] = knapsack(i - 1, k);
			}
			// 현재 물건(i)을 담을 수 있는 경우
			else {
				// 이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i])중 큰 값을 저장
				dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - w[i]) + v[i]);
			}
		}
		return dp[i][k];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		w = new int[N];
		v = new int[N];

		dp = new int[N][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(knapsack(N - 1, K));
	}



}
