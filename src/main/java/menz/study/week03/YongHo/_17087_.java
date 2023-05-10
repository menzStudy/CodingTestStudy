package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17087_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken()); // 동생의 수
    int S = Integer.parseInt(st.nextToken()); // 시작 위치

    String[] loc = br.readLine().split(" ");
    int[] diff = new int[N];

    for (int idx = 0; idx < diff.length; idx++) {
      diff[idx] = Math.abs(Integer.parseInt(loc[idx]) - S);
    }

    if (N == 1) {
      System.out.println(diff[0]);
      return;
    }

    Arrays.sort(diff);

    int gcd = gcd(diff[1], diff[0]);
    for (int idx = 2; idx < diff.length && gcd != 1; idx++) {
      gcd = gcd(diff[idx], gcd);
    }

    System.out.println(gcd);
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }

    return gcd(b, a % b);
  }
}
