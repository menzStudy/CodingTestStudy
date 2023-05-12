package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1406_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();

    StringBuilder result = new StringBuilder();

    String text = br.readLine();

    for (int i =0 ; i< text.length(); i++) {
      left.push(text.charAt(i));
    }

    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      String[] commands = br.readLine().split(" ");
      if ("L".equalsIgnoreCase(commands[0]) && !left.isEmpty()) {
        right.push(left.pop());
      } else if ("D".equalsIgnoreCase(commands[0]) && !right.isEmpty()) {
        left.push(right.pop());
      } else if ("B".equalsIgnoreCase(commands[0]) && !left.isEmpty()) {
        left.pop();
      } else if ("P".equalsIgnoreCase(commands[0])) {
        left.push(commands[1].charAt(0));
      }
    }

    while(!left.isEmpty()) {
      result.append(left.pop());
    }

    result.reverse();

    while(!right.isEmpty()) {
      result.append(right.pop());
    }

    System.out.println(result);
    br.close();
  }
}
