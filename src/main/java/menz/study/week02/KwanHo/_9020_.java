package menz.study.week02.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9020_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[] notPrimeCheck = new boolean[n + 1];

            notPrimeCheck[0] = notPrimeCheck[1] = true;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                for (int j = i * i; j <= n; j += i) {
                    if(j % i == 0) {
                        notPrimeCheck[j] = true;
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            int start = 0;
            int end = 0;
            for (int i = 2; i < notPrimeCheck.length; i++) {
                if(!notPrimeCheck[i] && !notPrimeCheck[n - i]) {
                    int minGap = Math.abs(i - (n - i));
                    if(min > minGap) {
                        min = minGap;
                        start = i;
                        end = n - i;
                    }
                }
            }

            sb.append(start + " ").append(end).append("\n");
        }

        System.out.println(sb);

    }
}
