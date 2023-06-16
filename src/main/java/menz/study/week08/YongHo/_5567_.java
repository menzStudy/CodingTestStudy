package menz.study.week08.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5567_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    boolean[][] graph = new boolean[N + 1][N + 1];
    boolean[] visited = new boolean[N + 1];
    int[] cnt = new int[N+1];

    StringTokenizer st;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int f1 = Integer.parseInt(st.nextToken());
      int f2 = Integer.parseInt(st.nextToken());

      graph[f1][f2] = true;
      graph[f2][f1] = true;
    }

    Queue<Integer> queue = new LinkedList<>();

    queue.offer(1);
    visited[1] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      int curCnt = cnt[cur];
      if (curCnt == 3) break;

      for (int i = 1; i <= N; i++) {
        if (!visited[i] && graph[cur][i]) {
          queue.offer(i);
          visited[i] = true;
          cnt[i] = curCnt + 1;
        }
      }
    }

    int count = 0;
    for (int i = 2 ; i <= N; i++) {
      if (cnt[i] <= 2 && visited[i])  count++;
    }

    System.out.println(count);

    br.close();
  }
}
