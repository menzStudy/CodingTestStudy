package menz.study.week04.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874_ {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();

        int n = Integer.parseInt(br.readLine());
        int lastValue = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(lastValue < num) {
                for (int j = lastValue + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                lastValue = num;
            }

            if(Integer.parseInt(stack.lastElement().toString()) != num) {
                System.out.println("NO");
                return ;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}

