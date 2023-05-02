package menz.study.week02.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9020_ {
  private static final boolean[] prime = new boolean[10_001];

  static {
    Arrays.fill(prime, true);
    prime[0] = false;
    prime[1] = false;

    for (int i = 2; i < 10_001; i++) {
      if (prime[i]) {
        for (int j = i + i; j < 10_001; j += i) {
          prime[j] = false;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      for (int j = num / 2; j > 1; j--) {
        if (prime[j] && prime[num - j]) {
          sb.append(j).append(" ").append(num - j).append("\n");
          break;
        }
      }
    }

    System.out.println(sb);
  }
}
