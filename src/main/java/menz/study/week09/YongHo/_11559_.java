package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11559_ {
  private static final int ROW = 12, COL = 6;
  private static int explosionCnt = 0;
  private static char[][] field = new char[ROW][COL];
  private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    for (int i = 0; i < ROW; i++) {
      line = br.readLine();
      for (int j = 0; j < COL; j++) {
        field[i][j] = line.charAt(j);
      }
    }

    boolean explosion;

    do {
      //      printField();
      explosion = scanField();
      if (explosion) {
        fillBottom();
        explosionCnt++;
      }
      //      printField();
    } while (explosion);

    System.out.println(explosionCnt);

    br.close();
  }

  private static boolean scanField() {
    boolean explosion = false;
    Queue<int[]> queue = new LinkedList<>();
    List<int[]> targets = new LinkedList<>();

    boolean[][] visited = new boolean[ROW][COL];
    for (int r = 0; r < ROW; r++) {
      for (int c = 0; c < COL; c++) {
        if (field[r][c] == '.') {
          visited[r][c] = true;
          continue;
        }

        if (!visited[r][c]) {
          visited[r][c] = true;
          int puyoCnt = 1;
          char curPuyo = field[r][c];
          queue.offer(new int[] {r, c});
          targets.add(new int[] {r, c});

          while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
              int nextR = cur[0] + dir[0];
              int nextC = cur[1] + dir[1];

              if (nextR < 0 || nextC < 0 || nextR >= ROW || nextC >= COL || visited[nextR][nextC])
                continue;

              if (field[nextR][nextC] == '.') {
                visited[nextR][nextC] = true;
              }

              if (field[nextR][nextC] == curPuyo) {
                puyoCnt++;
                visited[nextR][nextC] = true;
                queue.offer(new int[] {nextR, nextC});
                targets.add(new int[] {nextR, nextC});
              }
            }
          }

          if (puyoCnt >= 4) {
            explosion = true;
            explode(targets);
          }

          targets.clear();
        }
      }
    }

    return explosion;
  }

  private static void explode(List<int[]> targets) {
    for (int[] target : targets) {
      field[target[0]][target[1]] = '.';
    }
  }

  private static void fillBottom() {
    for (int c = 0; c < COL; c++) {
      int insertPos = -1;

      for (int r = ROW - 1; r >= 0; r--) {
        if (field[r][c] == '.') {
          insertPos = r;
          break;
        }
      }

      if (insertPos == -1) continue;

      int targetPos = insertPos - 1;

      while (targetPos >= 0) {
        if (field[targetPos][c] != '.') {
          field[insertPos][c] = field[targetPos][c];
          field[targetPos][c] = '.';
          while (field[insertPos][c] != '.' && insertPos != ROW) insertPos--;
          targetPos = insertPos;
        }
        targetPos--;
      }
    }
  }

  private static void printField() {
    System.out.println();
    for (int r = ROW - 1; r >= 0; r--) {
      System.out.println(Arrays.toString(field[r]).replaceAll("[,\\[\\]]", " "));
    }
  }
}
