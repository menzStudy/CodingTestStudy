package menz.study.week10.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
  int v;
  int cost;

  public Node(int v, int cost) {
    this.v = v;
    this.cost = cost;
  }
}

public class _1504_ {

  static int N, E;
  static ArrayList<Node>[] graph;
  static boolean[] visited;
  static int[] dist;
  static final int INF = 200000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];
    dist = new int[N + 1];
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
      dist[i] = INF;
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      // start -> end (양방향)
      graph[a].add(new Node(b, c));

      // end -> start (양방향)
      graph[b].add(new Node(a, c));
    }

    // 반드시 거쳐야 할 정점
    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    // 1 -> v1 -> v2 -> N으로 가는 경우
    int result1 = 0;
    result1 += dijkstra(1, v1);
    result1 += dijkstra(v1, v2);
    result1 += dijkstra(v2, N);

    // 1 -> v2 -> v1 -> N으로 가는 경우
    int result2 = 0;
    result2 += dijkstra(1, v2);
    result2 += dijkstra(v2, v1);
    result2 += dijkstra(v1, N);

    if (result1 >= INF && result2 >= INF) {
      System.out.println(-1);
    } else {
      System.out.println(Math.min(result1, result2));
    }
  }

  private static int dijkstra(int start, int end) {
    // 초기화
    Arrays.fill(dist, INF);
    Arrays.fill(visited, false);

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    queue.add(new Node(start, 0));
    visited = new boolean[N + 1];
    dist[start] = 0;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (!visited[now.v]) {
        visited[now.v] = true;
      }

      for (Node next : graph[now.v]) {
        if (!visited[next.v] && dist[next.v] > now.cost + next.cost) {
          dist[next.v] = now.cost + next.cost;
          queue.add(new Node(next.v, dist[next.v]));
        }
      }
    }
    return dist[end];
  }
}
