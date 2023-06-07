package menz.study.week07.YongHo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15652_ {

  static int N, M;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int[] selected = new int[M];

    for (int i = 1; i <= N; i++) {
      selected[0] = i;
      permutation(1, selected);
    }

    System.out.println(sb);
    br.close();
  }

  public static void permutation(int selectedCnt, int[] selected) {
    if (selectedCnt == M) {
      for (int i = 0; i < M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = selected[selectedCnt - 1]; i <= N; i++) {
      selected[selectedCnt] = i;
      permutation(selectedCnt + 1, selected);
    }
  }
}
