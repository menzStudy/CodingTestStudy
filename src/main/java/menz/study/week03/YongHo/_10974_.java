package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10974_ {
  private static int N;
  private static int[] selected;
  private static boolean[] visited;
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    br.close();

    selected = new int[N];
    visited = new boolean[N + 1];
    rec_func(0);

    System.out.println(sb);
  }

  private static void rec_func(int selectedCnt) {
    if (selectedCnt == N) {
      for (int num : selected) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        selected[selectedCnt] = i;
        rec_func(selectedCnt + 1);
        visited[i] = false;
      }
    }
  }
}
