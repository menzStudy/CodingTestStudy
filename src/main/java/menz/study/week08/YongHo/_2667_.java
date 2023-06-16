package menz.study.week08.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2667_ {
  static int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    char[][] map = new char[N][N];
    boolean[][] visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Queue<int[]> queue = new LinkedList<>();

    int blocks = 0;
    int houses, nextI, nextJ;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && map[i][j] == '1') {
          blocks++;
          visited[i][j] = true;
          queue.offer(new int[] {i, j});
          houses = 1;

          while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
              nextI = cur[0] + dir[0];
              nextJ = cur[1] + dir[1];

              if (nextI < 0
                  || nextJ < 0
                  || nextI >= N
                  || nextJ >= N
                  || map[nextI][nextJ] == '0'
                  || visited[nextI][nextJ]) continue;

              visited[nextI][nextJ] = true;
              queue.offer(new int[] {nextI, nextJ});
              houses++;
            }
          }
          pq.offer(houses);
        }
      }
    }

    System.out.println(blocks);
    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }

    br.close();
  }
}
