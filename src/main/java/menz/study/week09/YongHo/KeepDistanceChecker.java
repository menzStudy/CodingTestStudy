package menz.study.week09.YongHo;

import java.util.Arrays;

public class KeepDistanceChecker {
  public static void main(String[] args) {
    String[][] places =
        new String[][] {
          {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
          {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
          {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
          {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
          {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
    System.out.println(Arrays.toString(new KeepDistanceChecker().solution(places)));
  }

  public int[] solution(String[][] places) {
    int[] answer = new int[places.length];

    for (int room = 0; room < places.length; room++) {
      char[][] roomMap = new char[5][5];
      for (int r = 0; r < 5; r++) {
        for (int c = 0; c < 5; c++) {
          roomMap[r][c] = places[room][r].charAt(c);
        }
      }

      if (check(roomMap)) answer[room] = 1;
    }

    return answer;
  }

  private boolean check(char[][] roomMap) {
    int[][] dirs =
        new int[][] {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    for (int r = 0; r < 5; r++) {
      for (int c = 0; c < 5; c++) {
        if (roomMap[r][c] == 'P') {

          // 상하좌우 체크
          for (int idx = 0; idx < dirs.length; idx += 2) {
            int nextR = r + dirs[idx][0];
            int nextC = c + dirs[idx][1];
            if (nextR < 0 || nextC < 0 || nextR >= 5 || nextC >= 5) continue;
            if (roomMap[nextR][nextC] == 'P') return false;

            int nextRR = r + dirs[idx][0] * 2;
            int nextCC = c + dirs[idx][1] * 2;
            if (nextRR < 0 || nextCC < 0 || nextRR >= 5 || nextCC >= 5) continue;
            if (roomMap[nextR][nextC] == 'O' && roomMap[nextRR][nextCC] == 'P') return false;
          }

          // 대각선 체크
          for (int idx = 1; idx < dirs.length; idx += 2) {
            int nextR = r + dirs[idx][0];
            int nextC = c + dirs[idx][1];

            if (nextR < 0 || nextC < 0 || nextR >= 5 || nextC >= 5) continue;

            // 대각선에 사람이 있는데 파티션으로 막혀있지 않은 경우
            if (roomMap[nextR][nextC] == 'P'
                && (roomMap[r][nextC] != 'X' || roomMap[nextR][c] != 'X')) return false;
          }
        }
      }
    }
    return true;
  }
}
