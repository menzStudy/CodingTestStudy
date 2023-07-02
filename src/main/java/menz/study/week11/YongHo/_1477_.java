package menz.study.week11.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1477_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    List<Integer> stations = new ArrayList<>();
    stations.add(0);
    stations.add(l);

    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < n; i++) {
      stations.add(Integer.parseInt(st.nextToken()));
    }

    stations.sort(Integer::compare);

    br.close();

    int min = 1;
    int max = l - 1;

    while (min <= max) {
      int mid = min + (max - min) / 2;
      if (mid == 0) break;

      int cnt = 0;

      for (int idx = 0; idx < stations.size() - 1; idx++) {
        cnt += (stations.get(idx + 1) - stations.get(idx) - 1) / mid;
      }

      if (cnt > m) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    System.out.println(min);

    br.close();
  }
}
