package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1406_timeout {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder currentText = new StringBuilder(br.readLine());

    int M = Integer.parseInt(br.readLine());
    int curPos = currentText.length();
    for (int i = 0; i < M; i++) {
      String[] commands = br.readLine().split(" ");
      // 좌측 이동
      if ("L".equalsIgnoreCase(commands[0])) {
        curPos = Math.max(0, curPos - 1);
      }
      // 우측 이동
      else if ("D".equalsIgnoreCase(commands[0])) {
        curPos = Math.min(curPos + 1, currentText.length());
      }
      // 왼쪽 글자 삭제
      else if ("B".equalsIgnoreCase(commands[0]) && curPos != 0) {
        currentText.deleteCharAt(curPos - 1);
        curPos = Math.max(0, curPos - 1);
      }
      // 글자 삽입
      else if ("P".equalsIgnoreCase(commands[0])) {
        currentText.insert(curPos, commands[1]);
        curPos = Math.min(curPos + 1, currentText.length());
      }
    }

    System.out.println(currentText);
    br.close();
  }
}
