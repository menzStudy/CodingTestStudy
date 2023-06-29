package menz.study.week10.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11657_ {

    private static Edge[] edges;
    private static int N,M;
    private static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        if(bellmanFord(1)) {
            for (int i = 2; i <= N; i++) {
                if(dist[i] == Integer.MAX_VALUE) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
        } else {
            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean bellmanFord(int start) {
        dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                Edge cur = edges[j];

                if (dist[cur.from] == Integer.MAX_VALUE) continue;

                if(dist[cur.to] > dist[cur.from] + cur.time) {
                    dist[cur.to] = dist[cur.from] + cur.time;

                    if(i == N) {
                        dist[cur.to] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                Edge cur = edges[j];

                if (dist[cur.from] == Integer.MAX_VALUE) continue;

                if(dist[cur.to] > dist[cur.from] + cur.time) {
                    return  false;
                }
            }
        }

        return true;
    }
}

class Edge {
    int from,to,time;

    public Edge(int from, int to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }
}