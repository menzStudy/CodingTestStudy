package menz.study.week08.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1260_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    boolean[][] graph = new boolean[N + 1][N + 1];
    boolean[] visited = new boolean[N + 1];

    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine(), " ");
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      graph[from][to] = true;
      graph[to][from] = true;
    }

    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack;

    stack = new Stack<>();
    visited[V] = true;
    stack.push(V);

    while (!stack.isEmpty()) {
      int from = stack.pop();
      sb.append(from).append(" ");

      for (int to = 1; to <= N; to++) {
        if (graph[from][to] && !visited[to]) {
          visited[to] = true;
          stack.push(to);
          break;
        }
      }
    }

    sb.append("\n");

    visited = new boolean[N + 1];

    Queue<Integer> queue = new LinkedList<>();
    visited[V] = true;

    queue.offer(V);
    while (!queue.isEmpty()) {
      int from = queue.poll();
      sb.append(from).append(" ");

      for (int to = 1; to <= N; to++) {
        if (graph[from][to] && !visited[to]) {
          visited[to] = true;
          queue.offer(to);
        }
      }
    }

    System.out.println(sb);

    br.close();
  }
}
