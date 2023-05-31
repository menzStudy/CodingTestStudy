package menz.study.week06.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11055_ {

    private static int findMaxRange(int[] arr, int n) {
        int[] dpArr = new int[n + 1];

        dpArr[1] = arr[1];
        int max = arr[1];
        for (int i = 2; i <= n; i++) {
            dpArr[i] = arr[i];
            for (int j = 1; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dpArr[i] = Math.max(dpArr[i], dpArr[j] + arr[i]);
                }
            }
            max = Math.max(max, dpArr[i]);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findMaxRange(arr, n));
    }
}