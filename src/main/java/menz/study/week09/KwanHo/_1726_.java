package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1726_ {

    private static char[][] map;
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean[][] visited;
    private static int[] go = {1, 2, 3};
    private static Queue<Robot> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        q = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");
        q.add(new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));

        st = new StringTokenizer(br.readLine(), " ");
        map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);

        bfs();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Robot cur = q.poll();
            visited[cur.x][cur.y] = true;
            int dir = cur.dir;

            for (int i = 0; i < dirs.length; i++) {
                int nx = cur.x + dirs[i][0];
                int ny = cur.y + dirs[i][1];

                if(nx < 0 || ny < 0 || nx >= dirs.length || ny >= dirs.length
                        || visited[nx][ny] || map[nx][ny] == '1') continue;

                visited[nx][ny] = true;
                q.add(new Robot(nx, ny, dir, cur.cnt + 1));
            }
        }
    }
}

class Robot {
    int x, y, dir, cnt;

    public Robot(int x, int y, int dir, int cnt) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
    }
}