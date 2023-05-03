package menz.study.week02.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _6588_ {
  private static final boolean[] prime = new boolean[1_000_001];

  static {
    Arrays.fill(prime, true);
    prime[0] = false;
    prime[1] = false;

    for (int i = 2; i < 1_000_001; i++) {
      if (prime[i]) {
        for (int j = i + i; j < 1_000_001; j += i) {
          prime[j] = false;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int num = Integer.parseInt(br.readLine());
    while (num != 0) {
      boolean exist = false;
      for (int j = 2; j <= num / 2; j++) {
        if (prime[j] && prime[num - j]) {
          sb.append(num).append(" = ").append(j).append(" + ").append(num - j).append("\n");
          exist = true;
          break;
        }
      }

      if (!exist) {
        sb.append("Goldbach's conjecture is wrong.\n");
      }

      num = Integer.parseInt(br.readLine());
    }

    System.out.println(sb);
    br.close();
  }
}
