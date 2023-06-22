package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2234_ {
  private static final int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];
    int[][] roomMap = new int[N][M];
    PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int c = 0; c < M; c++) {
        map[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    Queue<int[]> queue = new LinkedList<>();
    Map<Integer, Integer> roomSizeMap = new HashMap<>();

    int roomCnt = 0, size;

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (roomMap[r][c] == 0) {
          roomCnt++;
          roomMap[r][c] = roomCnt;
          queue.offer(new int[] {r, c});

          size = 1;
          while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int row = cur[0];
            int col = cur[1];

            for (int idx = 0; idx < dirs.length; idx++) {
              if ((map[row][col] & (1 << idx)) == 0) {
                int nextR = row + dirs[idx][0];
                int nextC = col + dirs[idx][1];

                if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) continue;

                if (roomMap[nextR][nextC] == 0) {
                  size++;
                  roomMap[nextR][nextC] = roomCnt;
                  queue.offer(new int[] {nextR, nextC});
                }
              }
            }
          }

          roomSizeMap.put(roomCnt, size);
          pq.offer(size);
        }
      }
    }

    boolean[][] visited = new boolean[N][M];

    int maxRoomSize = Integer.MIN_VALUE;

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (!visited[r][c]) {
          visited[r][c] = true;
          queue.offer(new int[] {r, c});
          int curRoom = roomMap[r][c];

          while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
              int nextR = cur[0] + dir[0];
              int nextC = cur[1] + dir[1];

              if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M || visited[nextR][nextC])
                continue;

              if (roomMap[nextR][nextC] == curRoom) {
                visited[nextR][nextC] = true;
                queue.offer(new int[] {nextR, nextC});
              } else {
                int roomSize = roomSizeMap.get(curRoom) + roomSizeMap.get(roomMap[nextR][nextC]);
                if (roomSize > maxRoomSize) {
                  maxRoomSize = roomSize;
                }
              }
            }
          }
        }
      }
    }

    System.out.println(roomCnt);
    System.out.println(pq.poll());
    System.out.println(maxRoomSize);

    br.close();
  }
}
