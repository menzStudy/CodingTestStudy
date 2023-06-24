package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1916_ {
    static int N, M;
    static ArrayList<Bus2>[] map;
    static int[] dist;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        dist = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[start].add(new Bus2(end, weight));
        }

        st = new StringTokenizer(br.readLine());

        System.out.println(dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Bus2> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        pq.offer(new Bus2(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Bus2 curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Bus2 node : map[cur]) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Bus2(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}

class Bus2 implements Comparable<Bus2> {
    int end;
    int weight;

    Bus2(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Bus2 o) {
        return this.weight - o.weight;
    }
}