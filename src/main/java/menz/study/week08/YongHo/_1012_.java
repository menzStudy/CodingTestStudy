package menz.study.week08.YongHo;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012_ {
  static int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;
    int M, N, K;
    int m, n, count;

    boolean[][] map, visited;

    Queue<int[]> queue;
    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine(), " ");

      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      map = new boolean[M][N];
      visited = new boolean[M][N];
      queue = new LinkedList<>();
      count = 0;

      for (int k = 0; k < K; k++) {
        st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map[m][n] = true;
      }

      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j] && map[i][j]) {
            visited[i][j] = true;
            count++;
            queue.offer(new int[] {i, j});

            while (!queue.isEmpty()) {
              int[] cur = queue.poll();

              for (int[] dir : dirs) {
                int nextM = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];

                if (nextM < 0 || nextN < 0 || nextM >= M || nextN >= N) continue;

                if (!visited[nextM][nextN] && map[nextM][nextN]) {
                  visited[nextM][nextN] = true;
                  queue.offer(new int[] {nextM, nextN});
                }
              }
            }
          }
        }
      }
      sb.append(count).append("\n");
    }

    System.out.println(sb);

    br.close();
  }
}
