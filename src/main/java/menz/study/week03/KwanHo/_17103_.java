package menz.study.week03.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17103_ {

    private static boolean[] isNotPrime = new boolean[1_000_001];
    static {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < Math.sqrt(1_000_000); i++) {
            if(isNotPrime[i]) continue;
            for (int j = i * i; j <= 1_000_000; j += i) {
                isNotPrime[j] = true;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int answer = 0;

            int start = num / 2;
            int end = num / 2;
            for (int i = 0; i < num / 2; i++) {
                if(!isNotPrime[start] && !isNotPrime[end]) {
                    if(start + end == num) {
                        answer++;
                        start--;
                        end++;
                    }
                } else {
                    start--;
                    end++;
                }
            }

            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
