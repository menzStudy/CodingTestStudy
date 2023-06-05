package menz.study.week07.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11058_answer {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    long[] result = new long[101];

    for (int i = 1; i <= 6; i++) {
      result[i] = i;
    }

    for (int i = 7; i <= N; i++) {
      for (int j = 3; i - j >= 1; j++) {
        result[i] = Math.max(result[i], result[i - j] * (j - 1));
      }
    }

    System.out.println(result[N]);

    br.close();
  }
}
