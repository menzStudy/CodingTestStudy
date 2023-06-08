package menz.study.week07.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889_ {
  static int N;
  static int[][] powerMap;
  static boolean[] team;

  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    powerMap = new int[N][N];
    team = new boolean[N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) powerMap[i][j] = Integer.parseInt(st.nextToken());
    }

    recursion(0, 0);
    System.out.println(min);

    br.close();
  }

  private static void recursion(int selectedCnt, int startIdx) {
    if (selectedCnt == N / 2) {
      int team1 = 0;
      int team2 = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (team[i] && team[j]) team1 += powerMap[i][j];
          else if (!team[i] && !team[j]) team2 += powerMap[i][j];
        }
      }

      min = Math.min(min, Math.abs(team1 - team2));
      return;
    }

    for (int i = startIdx; i < N; i++) {
      if (!team[i]) {
        team[i] = true;
        recursion(selectedCnt + 1, i + 1);
        team[i] = false;
      }
    }
  }
}
