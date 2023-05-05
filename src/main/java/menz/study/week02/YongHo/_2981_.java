package menz.study.week02.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2981_ {
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    // 2 <= N <= 100
    // 1 <= Integer <= 1_000_000_000
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];
    while (N > 0) {
      nums[--N] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(nums);
    loop:
    for (int i = 2; i <= nums[0]; i++) {
      int remain = nums[0] % i;
      for (int j = 1; j < nums.length; j++) {
        if (nums[j] % i != remain) {
          continue loop;
        }
      }
      sb.append(i).append(" ");
    }

    int remain = nums[0];

    loop:
    for (int i = nums[0] + 1; i <= nums[1] - nums[0]; i++) {
      for (int j = 1; j < nums.length; j++) {
        if (nums[j] % i != remain) {
          continue loop;
        }
      }
      sb.append(i).append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb);
    br.close();
  }
}
