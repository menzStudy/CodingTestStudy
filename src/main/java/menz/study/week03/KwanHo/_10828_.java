package menz.study.week03.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10828_ {
    private static StringBuilder pushStack() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if(command.equals("push")) {
                stack.push(st.nextToken());
            } else if(command.equals("pop")) {
                if(stack.empty()) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(stack.pop()).append('\n');
            } else if(command.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if(command.equals("empty")) {
                if(stack.empty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if(command.equals("top")) {
                if (stack.empty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.peek()).append('\n');
                }
            }
        }

        return sb;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(pushStack());
    }
}
