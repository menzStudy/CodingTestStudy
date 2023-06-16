package menz.study.week08.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] result = new int[100_001];
    boolean[] visited = new boolean[100_001];

    Queue<Integer> queue = new LinkedList<>();

    queue.offer(N);
    visited[N] = true;

    while (!queue.isEmpty() && !visited[K]) {
      int cur = queue.poll();
      int sec = result[cur];

      int next1 = cur - 1;
      int next2 = cur + 1;
      int next3 = cur * 2;

      if (next1 >= 0 && !visited[next1]) {
        result[next1] = sec + 1;
        visited[next1] = true;
        queue.offer(next1);
      }

      if (next2 <= 100_000 && !visited[next2]) {
        result[next2] = sec + 1;
        visited[next2] = true;
        queue.offer(next2);
      }

      if (next3 <= 100_000 && !visited[next3]) {
        result[next3] = sec + 1;
        visited[next3] = true;
        queue.offer(next3);
      }
    }

    System.out.println(result[K]);

    br.close();
  }
}
