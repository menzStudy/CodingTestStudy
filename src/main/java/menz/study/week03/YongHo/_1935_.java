package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class _1935_ {
  static HashMap<Character, Double> opMap = new HashMap<>();

  static {
    for (int i = 0; i < 26; i++) {
      opMap.put((char) ('A' + i), 0.0);
    }
  }

  public static void main(String[] args) throws IOException {
    //    System.out.println(2_000_000_000 < Integer.MAX_VALUE); true
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String formula = br.readLine();
    for (int i = 0; i < N; i++) {
      opMap.put((char) ('A' + i), Double.parseDouble(br.readLine()));
    }

    Stack<Double> result = new Stack<>();
    // 20_000_000_000
    for (int idx = 0; idx < formula.length(); idx++) {
      if (formula.charAt(idx) == '+') {
        double op2 = result.pop();
        double op1 = result.pop();
        result.push(op1 + op2);
      } else if (formula.charAt(idx) == '-') {
        double op2 = result.pop();
        double op1 = result.pop();
        result.push(op1 - op2);
      } else if (formula.charAt(idx) == '*') {
        double op2 = result.pop();
        double op1 = result.pop();
        result.push(op1 * op2);
      } else if (formula.charAt(idx) == '/') {
        double op2 = result.pop();
        double op1 = result.pop();
        result.push(op1 / op2);
      } else {
        result.push(opMap.get(formula.charAt(idx)));
      }
    }

    System.out.printf("%.2f", result.pop());
    br.close();
  }
}
