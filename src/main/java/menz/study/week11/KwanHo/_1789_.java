package menz.study.week11.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1789_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long left = 1;
        long right = S;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = mid * (mid + 1) / 2;

          if(sum > S) {
              right = mid - 1;
          } else {
              left = mid + 1;
              result = mid;
          }
        }
        System.out.println(result);
    }
}
