package menz.study.week02.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int big = Math.max(A, B);
    int small = Math.min(A, B);
    int gcd = big % small == 0 ? small : big % small;

    while (A % gcd != 0 || B % gcd != 0) {
      big = small;
      small = gcd;
      gcd = big % small == 0 ? small : big % small;
    }

    int lcm = gcd * (A / gcd) * (B / gcd);

    System.out.println(gcd + "\n" + lcm);
  }
}
