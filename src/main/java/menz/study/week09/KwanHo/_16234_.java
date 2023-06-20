package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16234_ {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int L, R, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            if(cnt == N * N) break;
            answer++;
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x, y));
        int total = map[x][y];
        List<Node> changes = new ArrayList<>();
        changes.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < dir.length; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length
                        || visited[nx][ny]) continue;

                int gap = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
                if(gap < L || gap > R) continue;

                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
                changes.add(new Node(nx, ny));
                total += map[nx][ny];
            }
        }

        changeMap(changes, total);
    }

    private static void changeMap(List<Node> changes, int total) {
        int changeValue = total / changes.size();
        for (Node node : changes) {
            map[node.x][node.y] = changeValue;
        }
    }
}

class Node {
    int x,y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
