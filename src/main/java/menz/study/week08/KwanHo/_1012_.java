package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Warm {
    int x, y;

    Warm(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class _1012_ {

    private static int[][] map;
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];
            int cnt = 0;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if(map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Warm> q = new LinkedList<>();
        q.add(new Warm(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Warm cur = q.poll();
            map[cur.x][cur.y] = 0;

            for (int i = 0; i < dir.length; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length ||
                        visited[nx][ny] || map[nx][ny] == 0) continue;

                q.add(new Warm(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
