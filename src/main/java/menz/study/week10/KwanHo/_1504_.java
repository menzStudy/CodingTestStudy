package menz.study.week10.KwanHo;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class _1504_ {
    static int V;
    static int E;
    static List<Edge>[] edgeFrom;
    static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()) + 1;
        E = Integer.parseInt(st.nextToken());
        edgeFrom = new ArrayList[V];
        for(int i=0; i<V; i++) {
            edgeFrom[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeFrom[node1].add(new Edge(node2, cost));
            edgeFrom[node2].add(new Edge(node1, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,V-1);
        int path2 = dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,V-1);

        int minPath = Math.min(path1, path2);

        System.out.println(minPath >= INF ? -1 : minPath);
    }

    public static int dijkstra(int start, int target) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int v = cur.vertex;

            for (Edge next : edgeFrom[v]) {
                if (dist[next.vertex] > dist[v] + next.cost) {
                    dist[next.vertex] = dist[v] + next.cost;
                    pq.offer(next);
                }
            }
        }
        return dist[target];
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }
}