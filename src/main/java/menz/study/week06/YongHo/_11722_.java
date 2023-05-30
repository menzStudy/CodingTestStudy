package menz.study.week06.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11722_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int[] result = new int[N];
    result[0] = nums[0];
    int size = 1;

    for (int i = 1; i < N; i++) {
      if (result[size - 1] > nums[i]) {
        result[size++] = nums[i];
        continue;
      }

      int lIdx = 0;
      int rIdx = size - 1;

      while (lIdx < rIdx) {
        int mid = lIdx + (rIdx - lIdx) / 2;

        if (result[mid] > nums[i]) lIdx = mid + 1;
        else rIdx = mid;
      }
      result[rIdx] = nums[i];
    }

    System.out.println(size);
    br.close();
  }
}
