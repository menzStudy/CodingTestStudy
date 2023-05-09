package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2824_ {
  public static void main(String[] args) throws IOException {
    // 2_147_483_647
    // 1_000_000_000
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 1 <= N , M <= 1_000
    br.readLine();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    BigInteger A = BigInteger.ONE;
    while (st.hasMoreTokens()) {
      A = A.multiply(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
    }

    br.readLine();
    st = new StringTokenizer(br.readLine(), " ");
    BigInteger B = BigInteger.ONE;
    while (st.hasMoreTokens()) {
      B = B.multiply(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
    }

    String answer = gcd(A, B).toString();
    if (answer.length() > 9) {
      answer = answer.substring(answer.length() - 9);
    }
    System.out.println(answer);
    br.close();
  }

  private static BigInteger gcd(BigInteger a, BigInteger b) {
    if (b.equals(BigInteger.ZERO)) {
      return a;
    }
    return gcd(b, a.divideAndRemainder(b)[1]);
  }
}
