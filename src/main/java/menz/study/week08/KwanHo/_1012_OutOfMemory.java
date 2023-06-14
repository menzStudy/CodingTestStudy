package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Warm2 {
    int x, y;

    Warm2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * visited 배열 없이 bfs로 map을 탐색할 때 1이 있다면 map배열에서 0으로 바꿔주는 방식으로 문제 풀이를 진행하게 되면 OOM 발생.
 */
public class _1012_OutOfMemory {

    private static int[][] map;
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            map = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
            int k = Integer.parseInt(st.nextToken());

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
        Queue<Warm2> q = new LinkedList<>();
        q.add(new Warm2(x, y));

        while (!q.isEmpty()) {
            Warm2 cur = q.poll();
            map[cur.x][cur.y] = 0;

            for (int i = 0; i < dir.length; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 0) continue;

                q.add(new Warm2(nx, ny));
            }
        }
    }
}
