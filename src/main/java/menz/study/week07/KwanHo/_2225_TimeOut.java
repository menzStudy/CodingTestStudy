package menz.study.week07.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2225_TimeOut {

    private static int[] arr;
    private static int N, K;
    private static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int DIVIDE = 1_000_000_000;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        dfs(0, 0);

        System.out.println(cnt % DIVIDE);
    }

    private static void dfs(int num, int depth) {
        if(depth == K) {
            if(num == N) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i <= N; i++) {
            dfs(num + arr[i], depth + 1);
        }
    }
}
