package menz.study.week07.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889_ {

    private static int[][] temas;
    private static boolean[] visited;
    private static int N;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        temas = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                temas[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int depth) {
        if(N / 2 == depth) {
            findMinGap();
            return;
        }

        for (int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1,depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void findMinGap() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    startTeam += temas[i][j];
                    startTeam += temas[j][i];
                } else if(!visited[i] && !visited[j]){
                    linkTeam += temas[i][j];
                    linkTeam += temas[j][i];
                }
            }
        }

        int value = Math.abs(startTeam - linkTeam);

        if(value == 0) {
            System.out.println(value);
            System.exit(0);
        }
        answer = Math.min(value, answer);
    }
}