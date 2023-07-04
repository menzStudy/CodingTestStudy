package menz.study.week10.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1956번 - 운동
public class _1956_ {
  static final int INF = 4_000_001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    Edge[] edges = new Edge[E];

    int startV, destinationV, cost;
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      startV = Integer.parseInt(st.nextToken());
      destinationV = Integer.parseInt(st.nextToken());
      cost = Integer.parseInt(st.nextToken());

      // edges[i][0] : 출발점
      // edges[i][1] : 도착점
      // edges[i][2] : 가중치
      edges[i] = new Edge(startV, destinationV, cost);
    }

    System.out.println(floydWarshall(V, edges));

    br.close();
  }

  private static int floydWarshall(int V, Edge[] edges) {
    int[][] result = new int[V + 1][V + 1];
    Arrays.stream(result).forEach(row -> Arrays.fill(row, INF));

    for (int i = 1; i <= V; i++) {
      result[i][i] = 0;
    }
    for (Edge edge : edges) {
      result[edge.getStartV()][edge.getEndV()] = edge.getCost();
    }

    // 플로이드 와샬 알고리즘 수행
    for (int k = 1; k <= V; k++) {
      for (int i = 1; i <= V; i++) {
        for (int j = 1; j <= V; j++) {
          if (i == j) {
            continue;
          }

          if (result[i][j] > result[i][k] + result[k][j]) {
            result[i][j] = result[i][k] + result[k][j];
          }
        }
      }
    }

    int ans = INF;
    for (int i = 1; i <= V; i++) {
      for (int j = 1; j <= V; j++) {
        if (i == j) {
          continue;
        }

        // 자기 자신을 제외한 두 정점이
        // 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.
        if (result[i][j] != INF && result[j][i] != INF) {
          ans = Math.min(ans, result[i][j] + result[j][i]);
        }
      }
    }

    // ans 가 초기값이면 사이클이 존재하지 않음.
    ans = (ans == INF) ? -1 : ans;

    return ans;
  }

  private static class Edge implements Comparable<Edge> {
    int startV;
    int endV;
    int cost;

    public Edge(int startV, int endV, int cost) {
      this.startV = startV;
      this.endV = endV;
      this.cost = cost;
    }

    public int getStartV() {
      return startV;
    }

    public int getEndV() {
      return endV;
    }

    public int getCost() {
      return cost;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.cost, o.cost);
    }
  }
}
