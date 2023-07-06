package menz.study.week11.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20444_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        String answer = "NO";
        long left = 0;
        long right = n / 2;

        while (left <= right) {
            long x = (left + right) / 2;
            long y = n - x;
            long sum = (x + 1) * (y + 1);

            if(sum < k) {
                left = x + 1;
            } else if(sum > k) {
                right = x - 1;
            } else {
                answer = "YES";
                break;
            }
        }

        System.out.println(answer);
    }
}
