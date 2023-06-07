package menz.study.week07.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15652_ {
    private static int[] arr;
    private static StringBuilder sb;
    private static int cnt = 0;

    private static void dfs(int num, int depth, int N) {
        if(depth == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = num; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1, N);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        arr = new int[M];

        dfs(1, 0, N);

        System.out.println(sb);
    }
}
