package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17298_timeout {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] num = new int[N];
    int[] rightMax = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int idx = 0; idx < N; idx++) {
      num[idx] = Integer.parseInt(st.nextToken());
      rightMax[idx] = -1;
      for (int in = idx - 1; in >= 0; in--) {
        if (rightMax[in] == -1 && num[in] < num[idx]) {
          rightMax[in] = num[idx];
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int idx = 0; idx < N; idx++) {
      sb.append(rightMax[idx]).append(" ");
    }

    System.out.println(sb);
  }
}
