package menz.study.week05.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_ {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int T, max = 0;
  static int[] result = new int[11];
  static int[] nums;

  public static void main(String[] args) {
    input();
    solve();
  }

  private static void solve() {
    StringBuilder sb = new StringBuilder();

    for (int num : nums) {
      sb.append(result[num]).append("\n");
    }

    System.out.println(sb);
  }

  private static void input() {
    try {
      T = Integer.parseInt(br.readLine());
      nums = new int[T];

      for (int i = 0; i < T; i++) {
        nums[i] = Integer.parseInt(br.readLine());
        if (nums[i] > max) max = nums[i];
      }

      result[0] = result[1] = 1;
      result[2] = 2;

      for (int i = 3; i <= max; i++) {
        result[i] = result[i - 3] + result[i - 2] + result[i - 1];
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
