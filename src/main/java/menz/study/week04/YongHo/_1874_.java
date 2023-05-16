package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874_ {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    boolean[] visited = new boolean[N + 1];

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      int top = stack.isEmpty() ? 0 : stack.peek();

      while (top < num) {
        top++;
        if (!visited[top]) {
          visited[top] = true;
          sb.append("+\n");
          stack.push(top);
        }
      }

      if (stack.isEmpty()) {
        System.out.println("NO");
        br.close();
        return;
      }

      while (top > num) {
        sb.append("-\n");
        stack.pop();
        top = stack.isEmpty() ? -1 : stack.peek();
      }

      if (top == num) {
        sb.append("-\n");
        stack.pop();
      } else {
        System.out.println("NO");
        br.close();
        return;
      }
    }

    System.out.println(sb);
    br.close();
  }
}
