package menz.study.week06.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_ {

    private static int findRange(int[] sequence, int A) {
        int[] dp = new int[A + 1];

        int cnt = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(sequence[i] > sequence[j] && dp[i] <= dp[j]) {
                    dp[i]++;
                }
            }
            cnt = Math.max(dp[i], cnt);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] sequence = new int[A + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= A; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findRange(sequence, A));
    }
}
