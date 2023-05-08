package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2407_ {
  // 5 ≤ n ≤ 100
  // 5 ≤ m ≤ 100
  // m ≤ n
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    br.close();

    // nCm =  n! / m! / (n-m)!
    BigInteger answer = BigInteger.valueOf(N);

    for (int i = N - 1; i > (N - M); i--) {
      answer = answer.multiply(BigInteger.valueOf(i));
    }

    for (int j = M; j > 1; j--) {
      answer = answer.divide(BigInteger.valueOf(j));
    }

    System.out.println(answer);
  }
}
