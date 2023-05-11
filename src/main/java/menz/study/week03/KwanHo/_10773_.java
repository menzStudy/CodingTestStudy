package menz.study.week03.KwanHo;

import java.util.Scanner;
import java.util.Stack;

public class _10773_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if(num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        System.out.println(stack.stream().mapToInt(x -> x).sum());
    }
}
