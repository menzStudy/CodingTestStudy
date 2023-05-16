package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2493_failed_1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] height = new int[N];
    int[] receive = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    height[0] = Integer.parseInt(st.nextToken());

    int maxHeight = height[0];
    int maxIdx = 0;
    for (int idx = 1; idx < N; idx++) {
      height[idx] = Integer.parseInt(st.nextToken());
      if (height[idx - 1] > height[idx]) {
        receive[idx] = idx;
      } else if (receive[idx - 1] > height[idx]) {
        receive[idx] = receive[idx - 1];
      } else if (maxHeight > height[idx]) {
        receive[idx] = maxIdx + 1;
      } else if (maxHeight < height[idx]) {
        maxHeight = height[idx];
        maxIdx = idx;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int idx = 0; idx < N; idx++) {
      sb.append(receive[idx]).append(" ");
    }

    System.out.println(sb);
  }
}
