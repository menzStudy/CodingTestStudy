package menz.study.week07.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865_answer {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] result = new int[N + 1][K + 1];

    int W, V;

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      W = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());

      for (int idx = 1; idx <= K; idx++) {
        result[i][idx] = result[i - 1][idx];
      }

      for (int idx = 0; idx + W <= K; idx++) {
        result[i][idx + W] = Math.max(result[i][idx + W], result[i-1][idx] + V);
      }
    }

    int maxVal = 0;
    for (int idx = 0; idx <= K; idx++) {
      if (maxVal < result[N][idx]) maxVal = result[N][idx];
    }

    System.out.println(maxVal);

    br.close();
  }
}
