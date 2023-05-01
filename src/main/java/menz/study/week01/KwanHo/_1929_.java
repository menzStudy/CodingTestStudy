package menz.study.week01.KwanHo;

import java.util.Scanner;

public class _1929_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] isPrime = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if(isPrime[i]) continue;

            if(i >= M) sb.append(i).append('\n');

            for (int j = i + i; j <= N; j += i) {
                isPrime[j] = true;
            }
        }

        System.out.println(sb);
    }
}
