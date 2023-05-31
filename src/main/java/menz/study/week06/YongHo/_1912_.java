package menz.study.week06.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1912_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int cur;
    int curMax = 0;
    int max = 0;

    int maxNum = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      cur = Integer.parseInt(st.nextToken());
      if (maxNum < cur) maxNum = cur;
      curMax = Math.max(curMax + cur, cur);
      max = Math.max(max, curMax);
    }
    if (max == 0) max = maxNum;

    System.out.println(max);
  }
}
