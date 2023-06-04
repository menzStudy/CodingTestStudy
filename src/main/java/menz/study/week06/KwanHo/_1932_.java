package menz.study.week06.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1932_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tree.add(i, new ArrayList<>());
            dp.add(i, new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while (st.hasMoreTokens()) {
                tree.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        dp.get(0).add(tree.get(0).get(0));
        for (int i = 1; i < N; i++) {
            // 트리 행의 첫 번째 노드
            dp.get(i).add(dp.get(i - 1).get(0) + tree.get(i).get(0));

            for (int j = 1; j < i; j++) {
                dp.get(i).add(j, Math.max(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + tree.get(i).get(j));
            }

            // 트리 행의 마지막 노드
            dp.get(i).add(dp.get(i - 1).get(dp.get(i - 1).size() - 1) + tree.get(i).get(tree.get(i).size() - 1));
        }

        int max = 0;
        for (int i = 0; i < dp.get(N - 1).size(); i++) {
            max = Math.max(dp.get(N - 1).get(i), max);
        }
        System.out.println(max);
    }
}
