package menz.study.week05.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_ {

    private static int zero, one;

    private static void fibo(int n) {
        int[] dp = new int[n + 1];

        if(n == 0) {
            zero++;
            return;
        } else if(n == 1){
            one++;
            return;
        }

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        zero = dp[n - 1];
        one = dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            fibo(n);

            sb.append(zero + " " + one + "\n");
            zero = one = 0;
        }

        System.out.println(sb);

    }
}
