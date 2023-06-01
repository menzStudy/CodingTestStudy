package menz.study.week06.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] result = new int[N][10];
    for (int j = 1; j <= 9; j++) {
      result[0][j] = 1;
    }

    for (int i = 1; i < N; i++) {
      result[i][0] = result[i - 1][1];
      for (int j = 1; j < 9; j++) {
        result[i][j] = (result[i - 1][j - 1] + result[i - 1][j + 1]) % 1_000_000_000;
      }
      result[i][9] = result[i - 1][8];
    }

    int sum = 0;

    for (int i = 0; i <= 9; i++) {
      sum = (sum + result[N - 1][i]) % 1_000_000_000;
    }

    System.out.println(sum);

    br.close();
  }
}
