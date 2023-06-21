package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2146_ {

    private static int N;
    private static char[][] map;
    private static boolean[][] visited;
    private static char[][] tmpMap;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        tmpMap = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        char island = '1';
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == '1') {
                    divideIsland(i, j, island);
                    island++;
                }

                if(tmpMap[i][j] == '\u0000') {
                    tmpMap[i][j] = '0';
                }
            }
        }

        visited = new boolean[N][N];
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(tmpMap[i][j] != '0' && !visited[i][j]) {
                    answer = Math.min(answer, makeBridge(i, j, tmpMap[i][j]));
                    visited = new boolean[N][N];
                }
            }
        }

        System.out.println(answer);
    }

    private static void divideIsland(int x, int y, char island) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        tmpMap[x][y] = island;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dir.length; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N ||
                        visited[nx][ny] || map[nx][ny] == '0' || tmpMap[nx][ny] == island) continue;

                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                tmpMap[nx][ny] = island;
            }
        }
    }

    private static int makeBridge(int x, int y, char island) {
        Queue<Bridge> q = new LinkedList<>();
        q.add(new Bridge(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Bridge cur = q.poll();
            if(tmpMap[cur.x][cur.y] != '0' && tmpMap[cur.x][cur.y] != island) {
                return cur.cnt - 1;
            }

            for (int i = 0; i < dir.length; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N ||
                        visited[nx][ny] || tmpMap[nx][ny] == island) continue;

                q.add(new Bridge(nx, ny, cur.cnt + 1));
                visited[nx][ny] = true;
            }
        }

        return Integer.MAX_VALUE;
    }
}

class Bridge {
    int x, y, cnt;

    public Bridge(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
