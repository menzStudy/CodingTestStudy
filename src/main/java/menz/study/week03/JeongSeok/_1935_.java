package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1935_ {

    static Stack<Double> stack = new Stack();
    static int N;
    static double[] nums;

    private static void calculatePrefix(char word) {

        if ('A' <= word && word <= 'Z') {
            stack.push(nums[word - 'A']);
            return;
        }

        double first = stack.pop();
        double second = stack.pop();

        switch (word) {
            case '+':
                stack.push(second + first);
                break;
            case '-':
                stack.push(second - first);
                break;
            case '*':
                stack.push(second * first);
                break;
            case '/':
                stack.push(second / first);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String prefix = br.readLine();
        nums = new double[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < prefix.length(); i++) {
            calculatePrefix(prefix.charAt(i));
        }

        System.out.printf("%.2f", stack.pop());

    }

}