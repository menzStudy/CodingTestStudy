package menz.study.week03.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1406_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftstack = new Stack<>();
        Stack<Character> rightstack = new Stack<>();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            leftstack.push(str.charAt(i));
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            String command = br.readLine();
            switch(command.charAt(0)){
                case 'L':
                    if(!leftstack.isEmpty()) rightstack.push(leftstack.pop());
                    break;
                case 'D':
                    if(!rightstack.isEmpty()) leftstack.push(rightstack.pop());
                    break;
                case 'B':
                    if(!leftstack.isEmpty()) leftstack.pop();
                    break;
                case 'P':
                    leftstack.push(command.charAt(2));
            }
        }

        while (!leftstack.isEmpty()) rightstack.push(leftstack.pop());
        while (!rightstack.isEmpty()) sb.append(rightstack.pop());

        System.out.println(sb);
    }
}