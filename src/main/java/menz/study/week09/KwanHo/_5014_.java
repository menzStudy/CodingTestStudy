package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014_ {

    private static int[] map;
    private static int F,U,D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[F + 1];

        int answer = bfs(S, G);
        System.out.println(answer == -1 ? "use the stairs" : answer - 1);
    }

    private static int bfs(int S, int G) {
        Queue<Integer> q = new LinkedList<>();
        map[S] = 1;
        q.add(S);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == G) {
                return map[cur];
            }

            int x1 = cur + U;
            int x2 = cur - D;

            if(x1 <= F && map[x1] == 0) {
                q.add(x1);
                map[x1] = map[cur] + 1;
            }

            if (x2 >= 1 && map[x2] == 0) {
                q.add(x2);
                map[x2] = map[cur] + 1;
            }
        }

        return -1;
    }
}
