package menz.study.week09.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1916_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    int[] costs = new int[N + 1]; // 각 도시별 이동 비용
    int[][] costMap = new int[N + 1][N + 1];

    Arrays.fill(costs, Integer.MAX_VALUE);
    Arrays.stream(costMap).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));

    StringTokenizer st;

    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine(), " ");

      int sCity = Integer.parseInt(st.nextToken());
      int dCity = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      costMap[sCity][dCity] = Math.min(costMap[sCity][dCity], cost);
    }

    st = new StringTokenizer(br.readLine(), " ");
    int startCity = Integer.parseInt(st.nextToken());
    int destinationCity = Integer.parseInt(st.nextToken());

    Queue<Integer> queue = new LinkedList<>();

    costs[startCity] = 0;
    queue.offer(startCity);

    while (!queue.isEmpty()) {
      int currentCity = queue.poll();

      for (int destination = 1; destination <= N; destination++) {
        if (costMap[currentCity][destination] == Integer.MAX_VALUE) continue;

        if (costs[destination] > costs[currentCity] + costMap[currentCity][destination]) {
          costs[destination] =
              Math.min(costs[destination], costs[currentCity] + costMap[currentCity][destination]);
          queue.offer(destination);
        }
      }
    }

    System.out.println(costs[destinationCity]);

    br.close();
  }
}
