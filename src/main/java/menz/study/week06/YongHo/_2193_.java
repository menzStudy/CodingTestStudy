package menz.study.week06.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2193_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    long[][] result = new long[N + 1][2];

    result[1][0] = 0;
    result[1][1] = 1;

    for (int i = 2; i <= N; i++) {
      result[i][0] = result[i - 1][0] + result[i - 1][1];
      result[i][1] = result[i - 1][0];
    }

    System.out.println(result[N][0] + result[N][1]);

    br.close();
  }
}
