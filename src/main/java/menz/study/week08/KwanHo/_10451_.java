package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10451_ {

    private static int[][] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1][N + 1];
            visited = new boolean[N + 1];
            int cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i <= N; i++) {
                int v = Integer.parseInt(st.nextToken());
                arr[i][v] = arr[v][i] = 1;
            }

            for (int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i < arr.length; i++) {
            if(!visited[i] && arr[node][i] == 1) {
                dfs(i);
            }
        }
    }
}
