package menz.study.week04.KwanHo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while(q.size() > 1) {
            q.remove();
            int top = q.poll();
            q.offer(top);
        }

        System.out.println(q.peek());

    }
}