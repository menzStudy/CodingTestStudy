package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206_ {
  static int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    char[][] map = new char[N][M];
    int[][][] distance = new int[N][M][2];

    String line;
    for (int n = 0; n < N; n++) {
      line = br.readLine();
      for (int m = 0; m < M; m++) {
        map[n][m] = line.charAt(m);
      }
    }

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0, 0});
    distance[0][0][0] = 1;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curD = distance[cur[0]][cur[1]][cur[2]];

      for (int[] dir : dirs) {
        int nextN = cur[0] + dir[0];
        int nextM = cur[1] + dir[1];

        if (nextN < 0 || nextM < 0 || nextN >= N || nextM >= M) continue;

        // 현재 벽을 한 번도 부수지 않은 상태
        if (cur[2] == 0) {
          // 벽을 한 번도 부수지 않은 상태에서 벽이 아닐 경우
          if (distance[nextN][nextM][0] == 0 && map[nextN][nextM] == '0') {
            distance[nextN][nextM][0] = curD + 1;
            queue.offer(new int[] {nextN, nextM, 0});
          }
          // 벽을 한 번 부수고 해당 위치 방문
          else if (distance[nextN][nextM][1] == 0 && map[nextN][nextM] == '1') {
            distance[nextN][nextM][1] = curD + 1;
            queue.offer(new int[] {nextN, nextM, 1});
          }
        }
        // 벽을 한 번 부순 상태
        else {
          if (distance[nextN][nextM][1] == 0 && map[nextN][nextM] == '0') {
            distance[nextN][nextM][1] = curD + 1;
            queue.offer(new int[] {nextN, nextM, 1});
          }
        }
      }
    }

    if (distance[N - 1][M - 1][0] == 0 && distance[N - 1][M - 1][1] == 0) {
      System.out.println(-1);
    } else if (distance[N - 1][M - 1][0] != 0 && distance[N - 1][M - 1][1] != 0) {
      System.out.println(Math.min(distance[N - 1][M - 1][0], distance[N - 1][M - 1][1]));
    } else if (distance[N - 1][M - 1][0] != 0) {
      System.out.println(distance[N - 1][M - 1][0]);
    } else {
      System.out.println(distance[N - 1][M - 1][1]);
    }

    br.close();
  }
}
