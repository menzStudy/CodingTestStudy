package menz.study.week10.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4485_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[][] matrix, result;
    Queue<int[]> queue = new LinkedList<>();

    final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    int count = 1;
    while (N != 0) {
      matrix = new int[N][N];
      result = new int[N][N];

      Arrays.stream(result).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine(), " ");

        for (int j = 0; j < N; j++) {
          matrix[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      result[0][0] = matrix[0][0];
      queue.offer(new int[] {0, 0});

      while (!queue.isEmpty()) {
        int[] cur = queue.poll();

        for (int[] dir : dirs) {
          int nextR = cur[0] + dir[0];
          int nextC = cur[1] + dir[1];

          if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) continue;

          if (result[cur[0]][cur[1]] + matrix[nextR][nextC] < result[nextR][nextC]) {
            result[nextR][nextC] = result[cur[0]][cur[1]] + matrix[nextR][nextC];
            queue.offer(new int[] {nextR, nextC});
          }
        }
      }

      sb.append("Problem ").append(count++).append(": ").append(result[N - 1][N - 1]).append("\n");

      N = Integer.parseInt(br.readLine());
    }

    System.out.println(sb);
    br.close();
  }
}
