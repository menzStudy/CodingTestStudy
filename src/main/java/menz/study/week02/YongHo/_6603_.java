package menz.study.week02.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6603_ {
  private static final StringBuilder stringBuilder = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    while (!"0".equals(input[0])) {
      int len = Integer.parseInt(input[0]);

      int[] nums = new int[len];

      for (int i = 1; i < input.length; i++) {
        nums[i - 1] = Integer.parseInt(input[i]);
      }

      recursivePick(nums, new int[6], 6, 0, 0);

      stringBuilder.append("\n");

      input = br.readLine().split(" ");
    }

    System.out.println(stringBuilder);

    br.close();
  }

  public static void recursivePick(
      int[] nums, int[] selected, int totalCnt, int pickCnt, int startIdx) {

    if (totalCnt == pickCnt) {
      for (int i = 0; i < selected.length; i++) {
        stringBuilder.append(selected[i]);
        if (i != selected.length - 1) {
          stringBuilder.append(" ");
        } else {
          stringBuilder.append("\n");
        }
      }
      return;
    }

    for (int i = startIdx; i < nums.length; i++) {
      selected[pickCnt] = nums[i];
      recursivePick(nums, selected, totalCnt, pickCnt + 1, i + 1);
    }
  }
}
