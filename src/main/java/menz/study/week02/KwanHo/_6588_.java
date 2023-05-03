package menz.study.week02.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6588_ {
    private static boolean[] notPrimeCheck = new boolean[1_000_001];
    static {
        notPrimeCheck[0] = notPrimeCheck[1] = true;

        for (int i = 2; i <= Math.sqrt(1_000_000); i++) {
            for (int j = i * i; j <= 1_000_000; j += i) {
                notPrimeCheck[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                break;
            }

            for (int i = 2; i <= notPrimeCheck.length; i++) {
                if(!notPrimeCheck[n - i] && !notPrimeCheck[i]) {
                    sb.append(n + " = ").append(i + " + ").append(n - i).append('\n');
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
