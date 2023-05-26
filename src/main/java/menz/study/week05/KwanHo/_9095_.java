package menz.study.week05.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_ {

    private static int dp(int num) {
        int[] arr = new int[num + 1];

        if(num == 0) return 0;
        else if(num == 1) return 1;
        else if(num == 2) return 2;

        arr[0] = arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= num; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }

        return arr[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());

            sb.append(dp(num) + "\n");
        }

        System.out.println(sb);
    }
}
