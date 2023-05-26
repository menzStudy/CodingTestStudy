package menz.study.week05.YongHo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _11727_ {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] answer = new int[1001];
    answer[0] = 1;
    answer[1] = 1;
    answer[2] = 3;
    for (int i = 3; i <= 1000; i++) {
      answer[i] = (answer[i - 1] + answer[i - 2] * 2) % 10007;
    }

    System.out.println(answer[N]);

    br.close();
  }
}
