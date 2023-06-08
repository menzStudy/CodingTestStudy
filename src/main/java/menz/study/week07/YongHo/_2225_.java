package menz.study.week07.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2225_ {

  static int N, K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int[][] result = new int[K + 1][N + 1];

    for (int k = 1; k <= K; k++) {
      result[k][1] = k;
      for (int n = 2; n <= N; n++) {
        result[k][n] = (result[k][n - 1] + result[k - 1][n]) % 1_000_000_000;
      }
    }

    System.out.println(result[K][N]);

    br.close();
  }
}
