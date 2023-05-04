package menz.study.week02.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603_ {

    private static boolean[] lottoNumCheck;
    private static int[] lottoNum;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());

        while (k > 1) {
            lottoNum = new int[k];
            lottoNumCheck = new boolean[k];

            for(int i = 0; i < k; i++) {
                lottoNum[i] = Integer.parseInt(st.nextToken());
            }

            sb = new StringBuilder();

            findAllNumber(0, 0);

            System.out.println(sb);

            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
        }
    }

    private static void findAllNumber(int start, int depth) {
        if(depth == 6) {
            for (int i = 0; i < lottoNumCheck.length; i++) {
                if(lottoNumCheck[i]) {
                    sb.append(lottoNum[i] + " ");
                }
            }
            sb.append("\n");
        } else {
            for (int i = start; i < lottoNum.length; i++) {
                if(!lottoNumCheck[i]) {
                    lottoNumCheck[i] = true;
                    findAllNumber(i + 1, depth + 1);
                    lottoNumCheck[i] = false;
                }
            }
        }
    }
}
