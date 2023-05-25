package menz.study.week05.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_ {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    int[] num = new int[T];
    int max = 0;

    for (int idx = 0; idx < T; idx++) {
      int N = Integer.parseInt(br.readLine());
      num[idx] = N;
      if (N > max) max = N;
    }

    int[][] result = new int[max + 1][2];

    if (max < 1) {
      System.out.println("1 0");
      return;
    }

    result[0] = new int[] {1, 0};
    result[1] = new int[] {0, 1};

    for (int i = 2; i <= max; i++) {
      int[] cur = new int[2];
      cur[0] = result[i - 1][0] + result[i - 2][0];
      cur[1] = result[i - 1][1] + result[i - 2][1];
      result[i] = cur;
    }

    for (int idx = 0; idx < T; idx++) {
      sb.append(result[num[idx]][0]).append(" ").append(result[num[idx]][1]).append("\n");
    }

    System.out.println(sb);

    br.close();
  }
}
