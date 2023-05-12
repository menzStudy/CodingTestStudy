package menz.study.week03.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1935_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        String notation = br.readLine();
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < notation.length(); i++) {
            if('A' <= notation.charAt(i) && 'Z' >= notation.charAt(i)) {
                stack.push(arr[notation.charAt(i) - 'A']);
            } else {
                if(!stack.isEmpty()) {
                    double num1 = stack.pop();
                    double num2 = stack.pop();

                    switch (notation.charAt(i)) {
                        case '+':
                            stack.push(num2 + num1);
                            break;
                        case '-':
                            stack.push(num2 - num1);
                            break;
                        case '/':
                            stack.push(num2 / num1);
                            break;
                        case '*':
                            stack.push(num2 * num1);
                            break;
                    }
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}