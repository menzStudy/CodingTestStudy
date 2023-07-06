package menz.study.week11.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1477_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] section = new int[N + 2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            section[i] = Integer.parseInt(st.nextToken());
        }
        section[0] = 0;
        section[N + 1] = L;
        Arrays.sort(section);

        int left = 1;
        int right = L - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for(int i = 1; i < section.length; i++) {
                sum += (section[i] - section[i - 1] - 1) / mid;
            }

            if(sum > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
