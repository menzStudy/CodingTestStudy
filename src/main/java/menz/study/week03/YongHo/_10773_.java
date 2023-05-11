package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10773_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    while (K-- > 0) {
      int curNum = Integer.parseInt(br.readLine());
      if (curNum == 0 && !stack.isEmpty()) {
        stack.pop();
      } else {
        stack.push(curNum);
      }
    }

    int answer = 0;

    while(!stack.isEmpty()) {
      answer += stack.pop();
    }

    System.out.println(answer);
  }
}
