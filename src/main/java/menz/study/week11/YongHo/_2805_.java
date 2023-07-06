package menz.study.week11.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long[] trees = new long[N];

    st = new StringTokenizer(br.readLine(), " ");

    long maxHeight = 0;

    for (int i = 0; i < N; i++) {
      trees[i] = Integer.parseInt(st.nextToken());
      if (maxHeight < trees[i]) maxHeight = trees[i];
    }

    long lIdx = 0L;
    long rIdx = maxHeight + 1;

    while (lIdx < rIdx) {
      long mid = (lIdx + rIdx) / 2L;
      long sum = 0L;

      for (long tree : trees) {
        if (tree > mid) sum += (tree - mid);
      }

      if (sum < M) rIdx = mid;
      else lIdx = mid + 1;
    }

    System.out.println(rIdx - 1);

    br.close();
  }
}
