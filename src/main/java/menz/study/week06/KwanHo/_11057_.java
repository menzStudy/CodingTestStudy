package menz.study.week06.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11057_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][10];

        for (int i = 0; i <= 9; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i - 1][k] % 10007;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += arr[n][i];
        }

        System.out.println(answer % 10007);

    }
}
