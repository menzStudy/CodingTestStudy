package menz.study.week02.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_ {

    private static int[] arr;
    private static int N,M;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        sb = new StringBuilder();

        recursion(1, 0);

        System.out.println(sb);
    }

    private static void recursion(int start, int depth) {
        if(depth == M) {
            for(int num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++) {
            arr[depth] = i;
            recursion(i + 1, depth + 1);
        }
    }
}
