package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16234_ {

  static final int[][] dirs = new int[][] {
      { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    int[][] A = new int[N][N];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int c = 0; c < N; c++) {
        A[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    Arrays.stream(A).forEach(row -> System.out.println(Arrays.toString(row)));

    boolean[][] visited;
    Queue<int[]> queue;
    List<int[]> connected;
    int moveCnt = 0, count;

    boolean startMove = true;
    while (startMove) {
      startMove = false;
      visited = new boolean[N][N];

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          if (!visited[r][c]) {
            queue = new LinkedList<>();
            connected = new ArrayList<>();
            count = 0;

            visited[r][c] = true;

            queue.offer(new int[] { r, c });
            connected.add(new int[] { r, c });
            count += A[r][c];

            while (!queue.isEmpty()) {
              int[] cur = queue.poll();

              for (int[] dir : dirs) {
                int nextR = cur[0] + dir[0];
                int nextC = cur[1] + dir[1];

                if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
                  continue;

                int diff = Math.abs(A[cur[0]][cur[1]] - A[nextR][nextC]);
                if (L <= diff && diff <= R && !visited[nextR][nextC]) {
                  startMove = true;
                  visited[nextR][nextC] = true;
                  queue.offer(new int[] { nextR, nextC });
                  connected.add(new int[] { nextR, nextC });
                  count += A[nextR][nextC];
                }
              }
            }

            int population = count / connected.size();
            for (int[] nation : connected) {
              A[nation[0]][nation[1]] = population;
            }
          }
        }
      }

      Arrays.stream(A).forEach(row -> System.out.println(Arrays.toString(row)));

      if (startMove) {
        moveCnt++;
      }
    }

    System.out.println(moveCnt);

    br.close();
  }
}
