package menz.study.week10.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11404_ {

    private static int[][] dist;
    private static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(c, dist[a][b]);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i == j) {
                        continue;
                    }

                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dist[i][j] == INF) {
                    dist[i][j] = 0;
                }

                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
