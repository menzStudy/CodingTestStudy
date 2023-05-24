package menz.study.week05.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5430_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    loop:
    while (T-- > 0) {
      String p = br.readLine();
      int N = Integer.parseInt(br.readLine());
      String arrStr = br.readLine();
      String[] numStr = arrStr.substring(1, arrStr.length() - 1).split(",");
      int leftIdx = 0;
      int rightIdx = N - 1;

      boolean reverse = false;
      for (int i = 0; i < p.length(); i++) {
        char command = p.charAt(i);

        if (command == 'R') {
          reverse = !reverse;
        } else {
          if (rightIdx - leftIdx == -1) {
            sb.append("error\n");
            continue loop;
          } else {
            if (reverse) {
              rightIdx--;
            } else {
              leftIdx++;
            }
          }
        }
      }

      if (leftIdx > rightIdx) {
        sb.append("[]\n");
        continue;
      }

      if (reverse) {
        sb.append("[");
        for (int i = rightIdx; i >= leftIdx; i--) {
          sb.append(numStr[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n");
      } else {
        sb.append("[");
        for (int i = leftIdx; i <= rightIdx; i++) {
          sb.append(numStr[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n");
      }
    }

    System.out.println(sb);
    br.close();
  }
}
