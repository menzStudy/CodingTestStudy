package menz.study.week03.KwanHo;

import java.util.Scanner;

public class _10974_ {
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    private static int n;

    private static void recursion(int n, int depth) {
        if(depth == n) {
            for(int num : arr) {
                sb.append(num + " ");
            }
            sb.append('\n');
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                recursion(n, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n];
        arr = new int[n];

        recursion(n, 0);
        System.out.println(sb);
    }
}
