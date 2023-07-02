package menz.study.week10.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13549_ {
  private static final int MAX_IDX = 100_000;
  private static final int MIN_IDX = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // edge[0] 현재 위치, edge[1] 가중치
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));

    int[] result = new int[MAX_IDX + 1];
    Arrays.fill(result, Integer.MAX_VALUE);

    result[N] = 0;
    queue.offer(new int[] {N, 0});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      int pos = cur[0];

      if (result[pos] < cur[1]) continue;

      if (pos * 2 <= MAX_IDX) {
        if (result[pos] < result[pos * 2]) {
          result[pos * 2] = result[pos];
          queue.offer(new int[] {pos * 2, result[pos]});
        }
      }

      if (pos + 1 <= MAX_IDX) {
        if (result[pos] + 1 < result[pos + 1]) {
          result[pos + 1] = result[pos] + 1;
          queue.offer(new int[] {pos + 1, result[pos + 1]});
        }
      }

      if (pos - 1 >= MIN_IDX) {
        if (result[pos] + 1 < result[pos - 1]) {
          result[pos - 1] = result[pos] + 1;
          queue.offer(new int[] {pos - 1, result[pos - 1]});
        }
      }
    }

    System.out.println(result[K]);

    br.close();
  }
}
