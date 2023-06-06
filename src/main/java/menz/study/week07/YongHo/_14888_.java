package menz.study.week07.YongHo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888_ {

  static long maxResult = Long.MIN_VALUE;
  static long minResult = Long.MAX_VALUE;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = Integer.parseInt(br.readLine());

    long[] nums = new long[N];
    int[] opCnts = new int[4];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      nums[i] = Long.parseLong(st.nextToken());
    }

    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < 4; i++) {
      opCnts[i] = Integer.parseInt(st.nextToken());
    }

    permutationNum(nums, opCnts, 1, nums.length);

    System.out.println(maxResult);
    System.out.println(minResult);

    br.close();
  }

  public static void permutationNum(long[] nums, int[] opCnts, int selectedCnt, int totalCnt) {
    if (selectedCnt == totalCnt) {
      if (nums[selectedCnt - 1] > maxResult) {
        maxResult = nums[selectedCnt - 1];
      }
      if (nums[selectedCnt - 1] < minResult) {
        minResult = nums[selectedCnt - 1];
      }

      return;
    }

    for (int i = 0; i < 4; i++) {
      if (opCnts[i] > 0) {
        long op1 = nums[selectedCnt - 1];
        long op2 = nums[selectedCnt];
        opCnts[i] -= 1;
        switch (i) {
            // +
          case 0:
            nums[selectedCnt] = op1 + op2;
            permutationNum(nums, opCnts, selectedCnt + 1, totalCnt);
            nums[selectedCnt] = op2;
            break;
            // -
          case 1:
            nums[selectedCnt] = op1 - op2;
            permutationNum(nums, opCnts, selectedCnt + 1, totalCnt);
            nums[selectedCnt] = op2;
            break;
            // *
          case 2:
            nums[selectedCnt] = op1 * op2;
            permutationNum(nums, opCnts, selectedCnt + 1, totalCnt);
            nums[selectedCnt] = op2;
            break;
            // /
          case 3:
            nums[selectedCnt] = op1 / op2;
            permutationNum(nums, opCnts, selectedCnt + 1, totalCnt);
            nums[selectedCnt] = op2;
            break;
        }
        opCnts[i] += 1;
      }
    }
  }
}
