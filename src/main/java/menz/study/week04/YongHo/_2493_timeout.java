package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2493_timeout {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] height = new int[N];
    int[] destination = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int idx = 0; idx < N; idx++) {
      height[idx] = Integer.parseInt(st.nextToken());
    }

    for (int idx = 1; idx < N; idx++) {
      for (int prevIdx = idx - 1; prevIdx >= 0; prevIdx--) {
        if (height[prevIdx] >= height[idx]) {
          destination[idx] = prevIdx + 1;
          break;
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int idx = 0; idx < N; idx++) {
      sb.append(destination[idx]).append(" ");
    }

    System.out.println(sb);
  }
}
