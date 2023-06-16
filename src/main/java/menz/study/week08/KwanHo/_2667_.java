package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class _2667_ {
    private static char[][] map;
    private static boolean[][] visited;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == '1' && !visited[i][j]) {
                    list.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        sb.append(cnt + "\n");

        Collections.sort(list);
        list.stream().forEach(e -> sb.append(e + "\n"));

        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        int cnt = 1;
        Queue<int []> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dir.length; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map.length ||
                        map[nx][ny] == '0' || visited[nx][ny]) continue;

                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }

        return cnt;
    }
}
