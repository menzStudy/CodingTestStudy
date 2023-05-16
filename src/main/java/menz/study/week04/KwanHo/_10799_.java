package menz.study.week04.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')' && !stack.isEmpty()) {
                stack.pop();
            }

            if (i > 0) {
                if (str.charAt(i - 1) == '(' && str.charAt(i) ==')') {
                    cnt += stack.size();
                } else if (str.charAt(i - 1)==')' && str.charAt(i) ==')'){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

