package menz.study.week10.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1504_ {
  private static final int INF = 20_000_000;
  private static int N, E, V1, V2;
  private static ArrayList<int[]>[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    int a, b, c;
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      graph[a].add(new int[] {b, c});
      graph[b].add(new int[] {a, c});
    }

    st = new StringTokenizer(br.readLine(), " ");

    V1 = Integer.parseInt(st.nextToken());
    V2 = Integer.parseInt(st.nextToken());

    int OneToV1 = dijkstra(1, V1);
    int V1ToV2 = dijkstra(V1, V2);
    int V2ToN = dijkstra(V2, N);
    int result1;

    if (OneToV1 == INF || V1ToV2 == INF || V2ToN == INF) result1 = INF;
    else result1 = OneToV1 + V1ToV2 + V2ToN;

    int OneToV2 = dijkstra(1, V2);
    int V2ToV1 = dijkstra(V2, V1);
    int V1ToN = dijkstra(V1, N);

    int result2;
    if (OneToV2 == INF || V2ToV1 == INF || V1ToN == INF) result2 = INF;
    else result2 = OneToV2 + V2ToV1 + V1ToN;

    int answer = Math.min(result1, result2);

    System.out.println(answer == INF ? -1 : answer);

    br.close();
  }

  public static int dijkstra(int start, int end) {
    int[] result = new int[N + 1];

    for (int idx = 1; idx <= N; idx++) {
      result[idx] = INF;
    }

    // edge[0] : 도착정점, edge[1] : 가중치
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));

    result[start] = 0;
    pq.offer(new int[] {start, 0});

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int curDest = cur[0];
      int curWeight = cur[1];

      if (result[curDest] < curWeight) continue;

      for (int[] edge : graph[curDest]) {
        int next = edge[0];
        int nextWeight = edge[1];
        if (result[curDest] + nextWeight < result[next]) {
          result[next] = result[curDest] + nextWeight;
          pq.offer(new int[] {next, nextWeight});
        }
      }
    }

    return result[end];
  }
}
