package menz.study.week03.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1406_failed {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            stack.add(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        int pointer = str.length();

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while (st.hasMoreTokens()) {
                char ch = st.nextToken().charAt(0);
                if(ch == 'P') {
                    stack.insertElementAt(st.nextToken().charAt(0), pointer);
                    if(pointer != 0) {
                        pointer++;
                    }
                } else if(ch == 'L' && pointer != 0) {
                    pointer--;
                } else if(ch == 'D' && pointer != str.length() - 1) {
                    pointer++;
                } else if(ch == 'B'){
                    if(pointer - 1 >= 0) {
                        stack.remove(pointer - 1);
                        pointer--;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);

        System.out.println(sb);
    }
}
