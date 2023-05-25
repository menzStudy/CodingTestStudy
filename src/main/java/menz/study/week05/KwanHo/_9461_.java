package menz.study.week05.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461_ {

    private static long dp(int n) {
        long[] arr = new long[n + 1];

        if(n <= 3) {
            return 1;
        }

        arr[1] = arr[2] = arr[3] = 1;

        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i - 3] + arr[i - 2];
        }


        return arr[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            sb.append(dp(Integer.parseInt(br.readLine())) + "\n");
        }

        System.out.println(sb);
    }
}
