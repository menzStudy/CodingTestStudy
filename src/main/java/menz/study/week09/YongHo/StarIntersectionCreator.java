package menz.study.week09.YongHo;

import java.util.HashSet;
import java.util.Set;

public class StarIntersectionCreator {
  public String[] solution(int[][] line) {
    Set<int[]> list = new HashSet<>();

    for (int i = 0; i < line.length - 1; i++) {
      for (int j = i + 1; j < line.length; j++) {
        int[] eq1 = line[i];
        int[] eq2 = line[j];

        long A = (long) eq1[1] * eq2[2];
        long B = (long) eq1[2] * eq2[1];
        long numeratorX = A - B;

        A = (long) eq1[2] * eq2[0];
        B = (long) eq1[0] * eq2[2];
        long numeratorY = A - B;

        A = (long) eq1[0] * eq2[1];
        B = (long) eq1[1] * eq2[0];
        long denominator = A - B;

        if (denominator != 0 && numeratorX % denominator == 0 && numeratorY % denominator == 0) {
          list.add(new int[] {(int) (numeratorX / denominator), (int) (numeratorY / denominator)});
        }
      }
    }

    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;

    for (int[] pos : list) {
      if (minX > pos[0]) minX = pos[0];
      if (maxX < pos[0]) maxX = pos[0];
      if (minY > pos[1]) minY = pos[1];
      if (maxY < pos[1]) maxY = pos[1];
    }

    String[] answer = new String[maxY - minY + 1];

    for (int[] pos : list) {
      int x = pos[0] - minX;
      int y = maxY - pos[1];

      if (answer[y] == null) answer[y] = ".".repeat(maxX - minX + 1);

      answer[y] = new StringBuilder(answer[y]).replace(x, x + 1, "*").toString();
    }

    for (int i = 0; i < maxY - minY + 1; i++) {
      if (answer[i] == null) answer[i] = ".".repeat(maxX - minX + 1);
    }
    return answer;
  }
}
