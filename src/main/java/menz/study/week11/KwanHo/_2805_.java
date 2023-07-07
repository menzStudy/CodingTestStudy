package menz.study.week11.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] treeHeight = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            treeHeight[i] = Integer.parseInt(st.nextToken());

            if(max < treeHeight[i]) {
                max = treeHeight[i];
            }
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for(int tree : treeHeight) {

                if(tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            if(sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }
}
