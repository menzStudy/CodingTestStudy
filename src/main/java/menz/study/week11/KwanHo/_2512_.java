package menz.study.week11.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2512_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int min = 0;
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int M = Integer.parseInt(br.readLine());

        long answer = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for(int money : arr) {
                if(money > mid) {
                    sum += mid;
                } else {
                    sum += money;
                }
            }

            if(sum <= M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);

    }
}
