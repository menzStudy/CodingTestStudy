package menz.study.week10.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _4485_ {
    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problemCnt = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(problemCnt++).append(": ").append(dijkstra(map[0][0])).append("\n");
        }
        System.out.println(sb);
    }

    private static int dijkstra(int startCost) {
        PriorityQueue<Person> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        pq.add(new Person(0, 0, startCost));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Person cur = pq.poll();
            if(cur.x == N - 1 && cur.y == N - 1) {
                return cur.cost;
            }

            for (int i = 0; i < dirs.length; i++) {
                int nx = cur.x + dirs[i][0];
                int ny = cur.y + dirs[i][1];

                if(nx < 0 || ny < 0 || nx >= N ||
                        ny >= N || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                pq.offer(new Person(nx, ny, cur.cost + map[nx][ny]));
            }
        }

        return 0;
    }
}

class Person {
    int x,y,cost;

    public Person(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
