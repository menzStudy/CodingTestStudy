package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576_ {
  private static final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];

    Queue<int[]> queue = new LinkedList<>();

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int c = 0; c < M; c++) {
        map[r][c] = Integer.parseInt(st.nextToken());
        if (map[r][c] == 1) {
          queue.offer(new int[] {r, c});
        }
      }
    }

    br.close();

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      for (int[] dir : dirs) {
        int nextR = cur[0] + dir[0];
        int nextC = cur[1] + dir[1];

        if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M || map[nextR][nextC] == -1) continue;

        if (map[nextR][nextC] == 0) {
          map[nextR][nextC] = map[cur[0]][cur[1]] + 1;
          queue.offer(new int[] {nextR, nextC});
        }
      }
    }

    int day = 1;
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (map[r][c] == 0) {
          System.out.println(-1);
          return;
        }
        if (day < map[r][c]) day = map[r][c];
      }
    }

    System.out.println(day - 1);
  }
}
