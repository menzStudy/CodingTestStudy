package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5014_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    br.close();

    int F = Integer.parseInt(st.nextToken()); // 건물 층수
    int S = Integer.parseInt(st.nextToken()); // 시작
    int G = Integer.parseInt(st.nextToken()); // 목표
    int U = Integer.parseInt(st.nextToken()); // 엘리베이터 버튼
    int D = Integer.parseInt(st.nextToken()); // 엘리베이터 버튼

    boolean[] visited = new boolean[F + 1];

    Queue<int[]> queue = new LinkedList<>();

    visited[S] = true;

    queue.add(new int[] {S, 0});

    while (!queue.isEmpty()) {
      int[] floor = queue.poll(); // 현재 있는 층

      if (floor[0] == G) {
        System.out.println(floor[1]);
        return;
      }

      int nextU = floor[0] + U;
      int nextD = floor[0] - D;

      if (nextU <= F && !visited[nextU]) {
        visited[nextU] = true;
        queue.offer(new int[] {nextU, floor[1] + 1});
      }

      if (nextD >= 1 && !visited[nextD]) {
        visited[nextD] = true;
        queue.offer(new int[] {nextD, floor[1] + 1});
      }
    }

    System.out.println("use the stairs");
  }
}
