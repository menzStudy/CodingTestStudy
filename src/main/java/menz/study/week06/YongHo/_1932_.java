package menz.study.week06.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] triangle = new int[N][];

    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      triangle[i] = new int[i + 1];
      st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < i + 1; j++) {
        triangle[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] result = new int[N][];
    result[0] = new int[] {triangle[0][0]};

    for (int i = 1; i < N; i++) {
      result[i] = new int[i + 1];
      result[i][0] = triangle[i][0] + result[i - 1][0];
      result[i][i] = triangle[i][i] + result[i - 1][i - 1];

      for (int k = 1; k < i; k++) {
        result[i][k] = Math.max(result[i - 1][k - 1], result[i - 1][k]) + triangle[i][k];
      }
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      if (max < result[N - 1][i]) max = result[N - 1][i];
    }

    System.out.println(max);
    br.close();
  }
}
