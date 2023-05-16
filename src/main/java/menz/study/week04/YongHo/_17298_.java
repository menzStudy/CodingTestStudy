package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17298_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] num = new int[N];
    int[] rightMax = new int[N];
    int[] rightMaxIdx = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int idx = 0; idx < N; idx++) {
      num[idx] = Integer.parseInt(st.nextToken());
      rightMax[idx] = -1;
    }

    for (int idx = N - 2; idx >= 0; idx--) {
      int nextIdx = idx + 1;
      while (0 < nextIdx && nextIdx < N) {
        if (num[idx] < num[nextIdx]) {
          rightMax[idx] = num[nextIdx];
          rightMaxIdx[idx] = nextIdx;
          break;
        } else {
          nextIdx = rightMaxIdx[nextIdx];
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
