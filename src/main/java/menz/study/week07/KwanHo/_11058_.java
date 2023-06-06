package menz.study.week07.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11058_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];

        for(int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for(int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], (j + 1) * dp[i - (j + 2)]);
            }
        }

        System.out.println(dp[N]);
    }
}
