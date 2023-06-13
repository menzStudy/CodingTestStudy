package menz.study.week08.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2606_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    boolean[][] graph = new boolean[N + 1][N + 1];
    boolean[] visited = new boolean[N + 1];

    StringTokenizer st;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      graph[v1][v2] = true;
      graph[v2][v1] = true;
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    visited[1] = true;

    int count = 0;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int to = 1; to <= N; to++) {
        if (!visited[to] && graph[cur][to]) {
          visited[to] = true;
          count++;
          queue.add(to);
        }
      }
    }

    System.out.println(count);

    br.close();
  }
}
