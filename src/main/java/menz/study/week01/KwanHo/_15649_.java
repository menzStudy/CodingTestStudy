package KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649_ {
    private static boolean[] visited;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];

        permutation(n, m, 0);
    }

    private static void permutation(int n, int m, int start) {
        if(m == start) {
            for (int i = 0; i < start; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[start] = i + 1;
                permutation(n, m, start + 1);
                visited[i] = false;
            }
        }
    }
}
