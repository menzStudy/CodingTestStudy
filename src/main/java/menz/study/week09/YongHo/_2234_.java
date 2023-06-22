package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2234_ {
  private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    String[][] map = new String[N][M];
    int[][] roomMap = new int[N][M];
    PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int c = 0; c < M; c++) {
        int num = Integer.parseInt(st.nextToken());
        map[r][c] = String.format("%04d", Integer.parseInt(Integer.toBinaryString(num)));
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

            // S, 남 : row + 1
            if (map[row][col].charAt(0) == '0' && row + 1 < N && roomMap[row + 1][col] == 0) {
              size++;
              roomMap[row + 1][col] = roomCnt;
              queue.offer(new int[] {row + 1, col});
            }

            // E, 동 : c + 1
            if (map[row][col].charAt(1) == '0' && col + 1 < M && roomMap[row][col + 1] == 0) {
              size++;
              roomMap[row][col + 1] = roomCnt;
              queue.offer(new int[] {row, col + 1});
            }

            // N, 북 : row - 1
            if (map[row][col].charAt(2) == '0' && row - 1 >= 0 && roomMap[row - 1][col] == 0) {
              size++;
              roomMap[row - 1][col] = roomCnt;
              queue.offer(new int[] {row - 1, col});
            }

            // W, 서 : c - 1
            if (map[row][col].charAt(3) == '0' && col - 1 >= 0 && roomMap[row][col - 1] == 0) {
              size++;
              roomMap[row][col - 1] = roomCnt;
              queue.offer(new int[] {row, col - 1});
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
