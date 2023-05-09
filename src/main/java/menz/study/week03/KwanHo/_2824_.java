package menz.study.week03.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2824_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger num = BigInteger.ONE;
        while (st.hasMoreTokens()) {
            num = num.multiply(BigInteger.valueOf(Long.parseLong(st.nextToken())));
        }

        int n2 = Integer.parseInt(br.readLine());
        BigInteger num2 = BigInteger.ONE;
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            num2 = num2.multiply(BigInteger.valueOf(Long.parseLong(st.nextToken())));
        }

        String answer = String.valueOf(gcd(num.max(num2), num.min(num2)));

        System.out.println(answer.length() > 9 ? answer.substring(answer.length() - 9) : answer);
    }

    private static BigInteger gcd(BigInteger num1, BigInteger num2) {
        if(num2.equals(BigInteger.valueOf(0))) {
            return num1;
        }

        return gcd(num2, num1.mod(num2));
    }
}
