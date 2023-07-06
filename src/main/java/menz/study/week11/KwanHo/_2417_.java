package menz.study.week11.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2417_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long q = (long) Math.sqrt(num);

        if(q * q < num) q++;
        System.out.println(q);
    }
}
