package menz.study.week06.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11057_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] result = new int[N][10];

    for (int i = 0; i <= 9; i++) {
      result[0][i] = 1;
    }

    for (int j = 1; j < N; j++) {
      result[j][0] = result[j - 1][0];
      for (int i = 1; i <= 9; i++) {
        for (int k = i; k>=0; k--) {
          result[j][i] += (result[j - 1][k]) % 10_007;
        }
      }
    }

    int sum = 0;
    for (int i = 0; i <= 9; i++) {
      sum = (sum + result[N - 1][i]) % 10_007;
    }

    System.out.println(sum);

    br.close();
  }
}
