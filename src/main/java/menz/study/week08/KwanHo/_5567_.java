package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5567_ {

    private static ArrayList<Integer>[] list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());
            list[friend1].add(friend2);
            list[friend2].add(friend1);
        }

        for (ArrayList<Integer> sublist : list) {
            Collections.sort(sublist, Comparator.naturalOrder());
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int studentId) {
        Queue<Integer> q = new LinkedList<>();
        q.add(studentId);
        visited[studentId] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int friend = q.poll();

            for(int student : list[friend]) {
                if(friend == 1) {
                    q.add(student);
                    visited[student] = true;
                    cnt++;
                } else {
                    if(list[friend].get(0) == 1 && !visited[student]) {
                        visited[student] = true;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
