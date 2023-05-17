package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2812_memoryout {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    StringBuilder num = new StringBuilder(br.readLine());

    int resultLen = N - K;
    int startIdx = 0;
    while (num.length() != resultLen) {
      for (int i = '9'; i > '0'; i--) {
        int idx = num.indexOf((char) i + "", startIdx);
        if (idx != -1 && idx - startIdx <= K) {
          K -= (idx - startIdx);
          num.delete(startIdx, idx);
          startIdx++;
          break;
        }
      }
    }

    System.out.println(num);
  }
}
