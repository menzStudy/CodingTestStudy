package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725_ {

    private static StringBuilder sb;
    private static int[] parent;
    private static boolean[] visited;
    private static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        dfs(1, 0);
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i] + "\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int parentNode) {
        if(depth == arr.length) {
            return;
        }

        for (int i = 0; i < arr[depth].size(); i++) {
            if(!visited[arr[depth].get(i)] && arr[depth].get(i) != 0) {
                visited[arr[depth].get(i)] = true;
                dfs(arr[depth].get(i), depth);
            }
        }
        parent[depth] = parentNode;
    }
}
