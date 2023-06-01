package menz.study.week06.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] steps = new int[N + 1];
    int[] result = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      steps[i] = Integer.parseInt(br.readLine());
    }

    if (N <= 1) {
      System.out.println(steps[1]);
      return;
    }

    result[1] = steps[1];
    result[2] = steps[1] + steps[2];

    for (int i = 3; i <= N; i++) {
      result[i] = Math.max(result[i - 2], result[i - 3] + steps[i - 1]) + steps[i];
    }

    System.out.println(result[N]);
    br.close();
  }
}
