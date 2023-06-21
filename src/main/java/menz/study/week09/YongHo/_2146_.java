package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2146_ {
  static int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  static int N;
  static boolean[][] map;
  static int[][] islandMap;
  static int islandCnt;

  public static void main(String[] args) throws IOException {
    initialize();
    initializeNumMap(); // 각 섬마다 번호를 붙임

    boolean[][] visited = new boolean[N][N];
    Map<Integer, Queue<int[]>> startMap = new HashMap<>();

    for (int n = 1; n <= islandCnt; n++) {
      Queue<int[]> queue = new LinkedList<>();
      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          if (islandMap[r][c] == n && !visited[r][c]) {
            visited[r][c] = true;

            for (int[] dir : dirs) {
              int sideR = r + dir[0];
              int sideC = c + dir[1];

              if (sideR < 0 || sideC < 0 || sideR >= N || sideC >= N) continue;
              if (islandMap[sideR][sideC] == 0) {
                queue.offer(new int[] {sideR, sideC});
              }
            }
          }
        }
      }

      startMap.put(n, queue);
    }

    System.out.println(findMinDistance(startMap));
  }

  private static int findMinDistance(Map<Integer, Queue<int[]>> startMap) {
    int minDistance = Integer.MAX_VALUE;
    for (int key : startMap.keySet()) {
      boolean[][] visited = new boolean[N][N];
      int[][] distance = new int[N][N];
      Queue<int[]> newQueue = new LinkedList<>();
      for (int[] pos : startMap.get(key)) {
        visited[pos[0]][pos[1]] = true;
        distance[pos[0]][pos[1]] = 1;
        newQueue.offer(pos);
      }

      while (!newQueue.isEmpty()) {
        int[] cur = newQueue.poll();

        for (int[] dir : dirs) {
          int nextR = cur[0] + dir[0];
          int nextC = cur[1] + dir[1];

          if (nextR < 0
              || nextC < 0
              || nextR >= N
              || nextC >= N
              || visited[nextR][nextC]
              || islandMap[nextR][nextC] == key) continue;

          visited[nextR][nextC] = true;

          if (islandMap[nextR][nextC] == 0) {
            distance[nextR][nextC] = distance[cur[0]][cur[1]] + 1;
            newQueue.offer(new int[] {nextR, nextC});
            continue;
          }

          if (minDistance > distance[cur[0]][cur[1]])
            minDistance = distance[cur[0]][cur[1]];
        }
      }
    }
    return minDistance;
  }

  private static void initialize() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new boolean[N][N];

    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        if ("1".equals(st.nextToken())) map[i][j] = true;
      }
    }

    br.close();
  }

  private static void initializeNumMap() {
    islandMap = new int[N][N];
    boolean[][] visited = new boolean[N][N];

    islandCnt = 0;
    Queue<int[]> queue = new LinkedList<>();

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        if (map[r][c] && !visited[r][c]) {
          islandCnt++;
          islandMap[r][c] = islandCnt;
          visited[r][c] = true;

          queue.offer(new int[] {r, c});

          while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
              int nextR = cur[0] + dir[0];
              int nextC = cur[1] + dir[1];

              if (nextR < 0
                  || nextC < 0
                  || nextR >= N
                  || nextC >= N
                  || visited[nextR][nextC]
                  || !map[nextR][nextC]) continue;

              visited[nextR][nextC] = true;
              islandMap[nextR][nextC] = islandCnt;
              queue.offer(new int[] {nextR, nextC});
            }
          }
        }
      }
    }
  }
}
