package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10799_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();

    int count = 0;
    int answer = 0;
    for (int idx = 0; idx < line.length(); idx++) {
      if (line.charAt(idx) == '(') {
        count++;
      } else if (line.charAt(idx-1) == '(' && line.charAt(idx) == ')'){
        count--;
        answer += count;
      } else if (line.charAt(idx) == ')') {
        count--;
        answer += 1;
      }
    }

    System.out.println(answer);
  }
}
