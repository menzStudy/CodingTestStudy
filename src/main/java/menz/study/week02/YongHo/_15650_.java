package menz.study.week02.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_ {
  private static int N, M;
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    br.close();

    rec_func(new int[M], 0, 1);
    System.out.println(sb);
  }

  private static void rec_func(int[] selected, int pickCnt, int startNum) {
    if (pickCnt == M) {
      for (int i = 0; i < selected.length; i++) {
        sb.append(selected[i]);
        if (i == selected.length - 1) {
          sb.append("\n");
        } else {
          sb.append(" ");
        }
      }
      return;
    }

    for (int curNum = startNum; curNum <= N; curNum++) {
      selected[pickCnt] = curNum;
      rec_func(selected, pickCnt + 1, curNum + 1);
    }
  }
}
