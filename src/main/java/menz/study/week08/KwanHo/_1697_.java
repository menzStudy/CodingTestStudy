package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] distance = new int[1_000_01];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K, distance));
    }

    private static int bfs(int N, int K, int[] distance) {
        Queue<Integer> q = new LinkedList<>();
        distance[N] = 0;
        q.add(N);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if(cur == K) {
                return distance[cur];
            }

            int x1 = cur + 1;
            int x2 = cur - 1;
            int x3 = cur * 2;

            if(x1 >= 0 && x1 < distance.length && distance[x1] == 0) {
                q.add(x1);
                distance[x1] = distance[cur] + 1;
            }

            if(x2 >= 0 && x2 < distance.length && distance[x2] == 0) {
                q.add(x2);
                distance[x2] = distance[cur] + 1;
            }

            if(x3 >= 0 && x3 < distance.length && distance[x3] == 0) {
                q.add(x3);
                distance[x3] = distance[cur] + 1;
            }
        }

        return 0;
    }
}
