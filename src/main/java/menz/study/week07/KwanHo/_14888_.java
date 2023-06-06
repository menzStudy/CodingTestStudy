package menz.study.week07.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888_ {

    private static int[] nArr, operators;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nArr = new int[N];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nArr[0],1);
        System.out.println(max + "\n" + min);
    }

    private static void dfs(int num, int depth) {
        if(N == depth) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < operators.length; i++) {
            if(operators[i] > 0) {
                operators[i]--;

                if(i == 0) {
                    dfs(num + nArr[depth], depth + 1);
                } else if(i == 1) {
                    dfs(num - nArr[depth], depth + 1);
                } else if(i == 2) {
                    dfs(num * nArr[depth], depth + 1);
                } else {
                    dfs(num / nArr[depth], depth + 1);
                }

                operators[i]++;
            }
        }
    }
}
