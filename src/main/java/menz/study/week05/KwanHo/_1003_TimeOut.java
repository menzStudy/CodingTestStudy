package menz.study.week05.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_TimeOut {

    private static int zero, one;

    private static void fibo(int n) {
        if(n == 0) {
            zero++;
            return;
        } else if(n == 1) {
            one++;
            return;
        }

        fibo(n - 1);
        fibo(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());

            fibo(num);

            sb.append(zero + " " + one + "\n");
            zero = one = 0;
        }

        System.out.println(sb);

    }
}
