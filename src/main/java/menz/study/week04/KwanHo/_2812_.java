package menz.study.week04.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2812_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        String num = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = num.charAt(i) - '0';
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i] && K > 0) {
                stack.pop();
                K--;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            if(K > 0) {
                while(K-- > 0) {
                    stack.pop();
                }
            }
            sb.append(arr[stack.pop()]);
        }

        sb.reverse();

        System.out.println(sb);
    }
}
