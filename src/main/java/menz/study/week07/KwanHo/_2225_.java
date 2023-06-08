package menz.study.week07.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2225_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int DIVIDE = 1_000_000_000;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];

        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= K; i++) {
            dp[i][1] = dp[i - 1][1] + 1;
            for (int j = 2; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % DIVIDE;
            }
        }

        System.out.println(dp[K][N] % DIVIDE);
    }
}
