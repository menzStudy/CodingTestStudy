package menz.study.week02.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int divisor = gcd(n, m);
        int multiple = n * m / divisor;

        System.out.println(divisor);
        System.out.println(multiple);
    }

    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
