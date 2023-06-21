package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206_ {

    private static char[][] map;
    private static boolean[][][] visited;
    static int[][] dir = {{1, 0}, {-1 ,0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        map = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        visited = new boolean[2][map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;
        answer = Math.min(bfs(0, 0), answer);
        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        Queue<Person2> q = new LinkedList<>();
        q.add(new Person2(x, y, 1, false));
        visited[0][x][y] = true;

        while (!q.isEmpty()) {
            Person2 cur = q.poll();

            if(cur.x == map.length - 1 && cur.y == map[0].length - 1) {
                return cur.cnt;
            }

            for (int i = 0; i < dir.length; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;

                if(map[nx][ny] == '0') {
                    if(!cur.destroy && !visited[0][nx][ny]) {
                        q.add(new Person2(nx, ny, cur.cnt + 1, false));
                        visited[0][nx][ny] = true;
                    } else if(cur.destroy && !visited[1][nx][ny]) {
                        q.add(new Person2(nx, ny, cur.cnt + 1, true));
                        visited[1][nx][ny] = true;
                    }
                } else if(map[nx][ny] == '1') {
                    if(!cur.destroy) {
                        q.add(new Person2(nx, ny, cur.cnt + 1, true));
                        visited[1][nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}

class Person2 {
    int x, y, cnt;
    boolean destroy;

    public Person2(int x, int y, int cnt, boolean destroy) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.destroy = destroy;
    }
}
