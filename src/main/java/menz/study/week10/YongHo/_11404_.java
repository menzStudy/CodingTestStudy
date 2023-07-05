package menz.study.week10.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 11404번 - 플로이드
public class _11404_ {
  static final long INF = 100_000_000_001L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 도시의 개수 (정점 갯수)
    int numOfCities = Integer.parseInt(br.readLine());
    int numOfBuses = Integer.parseInt(br.readLine());

    // 각 도시에서 출발하는 버스 정보
    ArrayList<Bus>[] graph = new ArrayList[numOfCities + 1];
    for (int i = 1; i <= numOfCities; i++) {
      graph[i] = new ArrayList<>();
    }

    StringTokenizer st;
    int startCity, destinationCity, cost;
    for (int i = 0; i < numOfBuses; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      startCity = Integer.parseInt(st.nextToken());
      destinationCity = Integer.parseInt(st.nextToken());
      cost = Integer.parseInt(st.nextToken());

      graph[startCity].add(new Bus(destinationCity, cost));
    }

    long[][] answer = new long[numOfCities + 1][];

    StringBuilder sb = new StringBuilder();
    for (int start = 1; start <= numOfCities; start++) {
      answer[start] = dijkstra(start, numOfCities, graph);
      for (int dest = 1; dest <= numOfCities; dest++) {
        if (answer[start][dest] == INF) sb.append(0).append(" ");
        else sb.append(answer[start][dest]).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);

    br.close();
  }

  private static long[] dijkstra(int start, int numOfCities, ArrayList<Bus>[] graph) {
    long[] result = new long[numOfCities + 1];
    Arrays.fill(result, INF);
    result[start] = 0;

    PriorityQueue<Bus> busQueue = new PriorityQueue<>();

    busQueue.offer(new Bus(start, 0));

    while (!busQueue.isEmpty()) {
      Bus cur = busQueue.poll();

      int curCity = cur.getDestination();
      int curCost = cur.getCost();

      if (result[curCity] < curCost) continue;

      for (Bus bus : graph[curCity]) {
        int nextCity = bus.getDestination();
        int nextCost = bus.getCost();
        if (result[curCity] + nextCost < result[nextCity]) {
          result[nextCity] = result[curCity] + nextCost;
          busQueue.offer(bus);
        }
      }
    }

    return result;
  }

  private static class Bus implements Comparable<Bus> {
    int destination;
    int cost;

    public Bus(int destination, int cost) {
      this.destination = destination;
      this.cost = cost;
    }

    public int getDestination() {
      return destination;
    }

    public int getCost() {
      return cost;
    }

    @Override
    public int compareTo(Bus o) {
      return Integer.compare(this.cost, o.cost);
    }
  }
}
