package menz.study.week08.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11725_memory {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    boolean[][] graph = new boolean[100_001][100_001];
    boolean[] visited = new boolean[100_001];

    int[] parent = new int[N + 1];

    StringTokenizer st;
    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      graph[v1][v2] = true;
      graph[v2][v1] = true;
    }

    Queue<Integer> queue = new LinkedList<>();

    queue.offer(1);
    visited[1] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int to = 1; to <= N; to++) {
        if (!visited[to] && graph[cur][to]) {
          parent[to] = cur;
          visited[to] = true;
          queue.offer(to);
        }
      }
    }

    for (int i = 2; i <= N; i++) {
      System.out.println(parent[i]);
    }

    br.close();
  }
}
