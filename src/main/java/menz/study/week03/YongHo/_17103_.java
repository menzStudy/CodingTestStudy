package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17103_ {
  private static final boolean[] notPrime = new boolean[1_000_001];
  private static final StringBuilder sb = new StringBuilder();

  static {
    notPrime[0] = notPrime[1] = true;

    for (int i = 2; i < 1_000_001; i++) {
      if (!notPrime[i]) {
        for (int j = i + i; j < 1_000_001; j += i) {
          notPrime[j] = true;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      int answer = 0;
      int num = Integer.parseInt(br.readLine());
      for (int i = 2; i <= num / 2; i++) {
        if (!notPrime[i] && !notPrime[num - i]) {
          answer += 1;
        }
      }
      sb.append(answer).append("\n");
    }

    System.out.println(sb);

    br.close();
  }
}
