package menz.study.week02.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11653_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int num = Integer.parseInt(br.readLine());
    br.close();
    if (num == 1) {
      return;
    }

    while (num > 1) {
      boolean exist = false;
      for (int j = 2; j <= Math.sqrt(num); j++) {
        if (num % j == 0) {
          sb.append(j).append("\n");
          num /= j;
          exist = true;
          break;
        }
      }
      if (!exist) {
        sb.append(num).append("\n");
        break;
      }
    }

    System.out.println(sb);
  }
}
