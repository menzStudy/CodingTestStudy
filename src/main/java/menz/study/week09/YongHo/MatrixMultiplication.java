package menz.study.week09.YongHo;

public class MatrixMultiplication {
  public int[][] solution(int[][] arr1, int[][] arr2) {
    int[][] answer = new int[arr1.length][arr2[0].length];

    for (int r = 0; r < arr1.length; r++) {
      for (int c = 0; c < arr2[0].length; c++) {
        for (int i = 0; i < arr1[0].length; i++) {
          answer[r][c] += arr1[r][i] * arr2[i][c];
        }
      }
    }
    return answer;
  }
}
