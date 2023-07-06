package menz.study.week11.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2417번 - 정수제곱근
public class _2417_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 첫째 줄에 정수 n이 주어진다. (0 ≤ n < 2^63)

    long n = Long.parseLong(br.readLine());
    long left = 0;
    long right = n;

    while (left < right) {
      long mid = (left + right) / 2;

      if (Math.pow(mid, 2) < n) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    System.out.println(left);

    br.close();
  }
}
