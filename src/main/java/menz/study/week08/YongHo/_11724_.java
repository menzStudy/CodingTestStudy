package menz.study.week08.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _11724_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    boolean[][] graph = new boolean[N + 1][N + 1];
    boolean[] visited = new boolean[N + 1];

    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine(), " ");
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      graph[v1][v2] = true;
      graph[v2][v1] = true;
    }

    int from, count = 0;

    Stack<Integer> stack;

    for (int v = 1; v <= N; v++) {
      if (!visited[v]) {
        count++;
        stack = new Stack<>();
        visited[v] = true;
        stack.push(v);

        while (!stack.isEmpty()) {
          from = stack.pop();

          for (int to = 1; to <= N; to++) {
            if (graph[from][to] && !visited[to]) {
              visited[to] = true;
              stack.push(to);
            }
          }
        }
      }
    }

    System.out.println(count);

    br.close();
  }
}
