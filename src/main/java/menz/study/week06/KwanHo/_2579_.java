package menz.study.week06.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            if(i == 2) {
                dp[i] = arr[i] + arr[i - 1];
            } else if(i == 3) {
                dp[i] = Math.max(arr[i - 1], arr[i - 2]) + arr[i];
            } else {
                dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
            }
        }

        System.out.println(dp[N]);
    }
}
