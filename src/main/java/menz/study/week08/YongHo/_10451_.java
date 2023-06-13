package menz.study.week08.YongHo;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _10451_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    boolean[][] graph;
    boolean[] visited;
    int V, to, count;
    StringTokenizer st;
    Queue<Integer> queue;

    for (int i = 0; i < T; i++) {
      V = Integer.parseInt(br.readLine());
      queue = new LinkedList<>();
      graph = new boolean[V + 1][V + 1];
      visited = new boolean[V + 1];
      count = 0;

      st = new StringTokenizer(br.readLine(), " ");
      for (int from = 1; from <= V; from++) {
        to = Integer.parseInt(st.nextToken());

        graph[from][to] = true;
        graph[to][from] = true;
      }

      for (int start = 1; start <= V; start++) {
        if (!visited[start]) {
          count++;
          queue.offer(start);

          while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int v = 1; v <= V; v++) {
              if (!visited[v] && graph[cur][v]) {
                visited[v] = true;
                queue.offer(v);
              }
            }
          }
        }
      }
      bw.write(count + "\n");
    }

    bw.close();
    br.close();
  }
}
