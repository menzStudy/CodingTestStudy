package menz.study.week06.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11055_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];
    int[] sum = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int curIdx = 0; curIdx < N; curIdx++) {
      nums[curIdx] = Integer.parseInt(st.nextToken());
      sum[curIdx] = nums[curIdx];
      for (int prevIdx = curIdx - 1; prevIdx >= 0; prevIdx--) {
        if (nums[prevIdx] < nums[curIdx]) {
          sum[curIdx] = Math.max(sum[curIdx], sum[prevIdx] + nums[curIdx]);
        }
      }
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      if (max < sum[i]) max = sum[i];
    }

    System.out.println(max);
  }
}
