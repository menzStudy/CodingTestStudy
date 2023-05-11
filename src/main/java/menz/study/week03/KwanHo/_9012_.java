package menz.study.week03.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class _9012_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            boolean chk = true;
            String str = br.readLine();
            char[] ch = str.toCharArray();

            for (int j = 0; j < ch.length; j++) {
                if(ch[j] == '(') {
                    stack.push('(');

                } else if(ch[j] == ')') {
                    if(stack.empty()) {
                        chk = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.empty()) {
                chk = false;
            }

            System.out.println(chk ? "YES" : "NO");
            stack = new Stack<>();
        }

    }
}
