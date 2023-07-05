package menz.study.week10.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1753_ {
    private static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<_1753_Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.get(Integer.parseInt(st.nextToken())).add(new _1753_Node(
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dijkstra(start, graph);
    }

    private static void dijkstra(int start, ArrayList<ArrayList<_1753_Node>> graph) {
        int[] dist = new int[V + 1];

        for (int i = 1; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<_1753_Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new _1753_Node(start, 0));

        while (!pq.isEmpty()) {
            _1753_Node cur = pq.poll();

            if(dist[cur.to] < cur.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                _1753_Node adjNode = graph.get(cur.to).get(i);

                if(dist[adjNode.to] > cur.weight + adjNode.weight) {
                    dist[adjNode.to] = cur.weight + adjNode.weight;
                    pq.offer(new _1753_Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF ");
            } else {
                System.out.println(dist[i] + " ");
            }
        }
    }
}

class _1753_Node {
    int to;
    int weight;

    public _1753_Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}