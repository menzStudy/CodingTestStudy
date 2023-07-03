package menz.study.week10.JeongSeok;

import java.io.*;
import java.util.*;

public class _13549_ {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int subin = Integer.parseInt(st.nextToken());
    int sister = Integer.parseInt(st.nextToken());

    int[] distance = new int[100_001];
    boolean[] visited = new boolean[100_001];
    Deque<Integer> queue = new LinkedList<>();

    queue.add(subin);
    distance[subin] = 0;
    visited[subin] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      if (cur == sister) {
        System.out.println(distance[cur]);
        return;
      }

      int x1 = cur + 1;
      int x2 = cur - 1;
      int x3 = cur * 2;

      if (x3 <= 100000 && !visited[x3]) {
        queue.addFirst(x3);
        distance[x3] = distance[cur];
        visited[x3] = true;
      }

      if (x2 >= 0 && !visited[x2]) {
        queue.add(x2);
        distance[x2] = distance[cur] + 1;
        visited[x2] = true;
      }

      if (x1 <= 100000 && !visited[x1]) {
        queue.add(x1);
        distance[x1] = distance[cur] + 1;
        visited[x1] = true;
      }
    }
  }
}
