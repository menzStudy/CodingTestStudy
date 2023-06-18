package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589_ {

  static final int[][] dirs = new int[][] {
      { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int ROW = Integer.parseInt(st.nextToken());
    int COL = Integer.parseInt(st.nextToken());

    boolean[][] landMap = new boolean[ROW][COL];
    boolean[][] visited = new boolean[ROW][COL];
    int[][] distance = new int[ROW][COL];

    String line;
    for (int r = 0; r < ROW; r++) {
      line = br.readLine();
      for (int c = 0; c < COL; c++) {
        if (line.charAt(c) == 'L')
          landMap[r][c] = true;
      }
    }

    Queue<int[]> queue = new LinkedList<>();

    int maxDistance = 0;

    for (int r = 0; r < ROW; r++) {
      for (int c = 0; c < COL; c++) {
        if (landMap[r][c]) {
          visited = new boolean[ROW][COL];
          distance = new int[ROW][COL];
          visited[r][c] = true;
          queue.offer(new int[] { r, c });

          while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curDistance = distance[cur[0]][cur[1]];

            for (int[] dir : dirs) {
              int nextR = cur[0] + dir[0];
              int nextC = cur[1] + dir[1];

              if (nextR < 0 || nextC < 0 || nextR >= ROW || nextC >= COL || !landMap[nextR][nextC]
                  || visited[nextR][nextC])
                continue;

              visited[nextR][nextC] = true;
              distance[nextR][nextC] = curDistance + 1;
              queue.offer(new int[] { nextR, nextC });

              if (maxDistance < distance[nextR][nextC])
                maxDistance = distance[nextR][nextC];
            }

          }

        }
      }
    }

    System.out.println(maxDistance);

    br.close();
  }
}
