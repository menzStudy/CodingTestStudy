package menz.study.week06.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15486_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N + 2][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];
        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }

            int day = i + schedule[i][0];

            if(day <= N + 1) {
                dp[day] = Math.max(dp[day], schedule[i][1] + max);
            }
        }

        System.out.println(max);
    }
}
