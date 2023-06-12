package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1260_ {
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        dfs(V);
        visited = new boolean[N + 1];
        sb.append('\n');

        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for (int i = 0; i < arr[start].size(); i++) {
            if(!visited[arr[start].get(i)]) {
                visited[arr[start].get(i)] = true;
                dfs(arr[start].get(i));
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node + " ");

            for (int i = 0; i < arr[node].size(); i++) {
                if(!visited[arr[node].get(i)]) {
                    visited[arr[node].get(i)] = true;
                    q.add(arr[node].get(i));
                }
            }
        }
    }
}
