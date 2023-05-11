package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _9012_ {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String line = br.readLine();

      int cnt = 0;

      for (int idx = 0; idx < line.length(); idx++) {
        if (line.charAt(idx) == '(') {
          cnt++;
        } else {
          cnt--;
        }
        if (cnt < 0) {
          break;
        }
      }

      if (cnt == 0) {
        sb.append("YES");
      } else {
        sb.append("NO");
      }
      sb.append("\n");
    }

    System.out.print(sb);

    br.close();
  }
}
