package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2606_ {
    private static int[][] arr;
    private static boolean[] visited;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = arr[v][u] = 1;
        }

        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i < arr.length; i++) {
            if(arr[node][i] == 1 && !visited[i]) {
                cnt++;
                dfs(i);
            }
        }
    }
}
