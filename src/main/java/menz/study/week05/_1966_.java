package menz.study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1966_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCnt = Integer.parseInt(br.readLine());

        while (totalCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;

            Queue<int []> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; i++) {
                q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            while (true) {
                int cur[] = q.poll();
                boolean flag = true;

                for(int num[] : q) {
                    if(num[1] > cur[1]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    cnt++;
                    if(cur[0] == M) break;
                } else {
                    q.add(cur);
                }
            }

            System.out.println(cnt);
        }
    }
}
