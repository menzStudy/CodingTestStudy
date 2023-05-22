package menz.study.week05.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1966_ {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    int N, M;

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    for (int i = 0; i < T; i++) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
      Queue<int[]> queue = new LinkedList<>();
      st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < N; j++) {
        int temp = Integer.parseInt(st.nextToken());
        pq.offer(temp);
        queue.add(new int[] {j, temp});
      }

      int count = 0;

      while (!pq.isEmpty()) {
        count++;

        int curMax = pq.poll();
        while (queue.peek()[1] != curMax) {
          queue.offer(queue.poll());
        }

        int[] doc = queue.poll();
        if (doc[0] == M) {
          sb.append(count).append("\n");
          break;
        }
      }
    }
    System.out.println(sb);
  }
}
