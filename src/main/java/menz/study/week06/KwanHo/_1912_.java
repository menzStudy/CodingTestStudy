package menz.study.week06.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1912_ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr[1] = Integer.parseInt(st.nextToken());
        int max = arr[1];
        for (int i = 2; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(arr[i - 1] + num > num) {
                arr[i] = arr[i - 1] + num;
            } else {
                arr[i] = num;
            }
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }
}
