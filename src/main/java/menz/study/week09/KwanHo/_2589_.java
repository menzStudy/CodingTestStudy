package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589_ {

    private static char[][] map;
    private static boolean[][] visited;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        map = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        visited = new boolean[map.length][map[0].length];
        int answer = 0;

        for (int i = 0; i < map.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i, j));
                    visited = new boolean[map.length][map[0].length];
                }
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        Queue<Person> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Person(x, y, 0));
        int hour = 0;

        while (!q.isEmpty()) {
            Person cur = q.poll();
            hour = cur.hour;

            for (int i = 0; i < dir.length; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length
                || map[nx][ny] == 'W' || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Person(nx, ny, cur.hour + 1));
            }
        }

        return hour;
    }
}

class Person {
    int x, y, hour;

    public Person(int x, int y, int hour) {
        this.x = x;
        this.y = y;
        this.hour = hour;
    }
}