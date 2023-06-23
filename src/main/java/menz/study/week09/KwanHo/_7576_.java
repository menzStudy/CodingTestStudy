package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576_ {
    private static char[][] box;
    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static Queue<Tomato> q = new LinkedList<>();
    private static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == '1') {
                    q.add(new Tomato(i, j, 1));
                    box[i][j] =  (char) (1 + '0');
                }
            }
        }

        int day = bfs();
        System.out.println(checkTomatoes() ? day : -1);
    }

    private static int bfs() {
        int day = 0;
        while (!q.isEmpty()) {
            Tomato cur = q.poll();
            day = cur.cnt - 1;

            for (int i = 0; i < dirs.length; i++) {
                int nx = cur.x + dirs[i][0];
                int ny = cur.y + dirs[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M
                        || box[nx][ny] != '0') continue;

                q.add(new Tomato(nx, ny, cur.cnt + 1));
                box[nx][ny] = (char) (cur.cnt + '0');
            }
        }

        return day;
    }

    private static boolean checkTomatoes() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == '0') {
                    return false;
                }
            }
        }

        return true;
    }
}

class Tomato {
    int x, y, cnt;

    public Tomato(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

