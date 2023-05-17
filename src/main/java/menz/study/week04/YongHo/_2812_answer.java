package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2812_answer {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int resultLen = N - K;

    String origin = br.readLine();
    br.close();

    Deque<Character> deque = new LinkedList<>();
    for (int idx = 0; idx < origin.length(); idx++) {
      while (!deque.isEmpty() && K > 0) {
        char v = deque.pollLast();
        K -= 1;
        if (v >= origin.charAt(idx)) {
          deque.offerLast(v);
          K += 1;
          break;
        }
      }
      if (deque.size() < resultLen) {
        deque.offerLast(origin.charAt(idx));
      }
    }

    StringBuilder sb = new StringBuilder();
    while(!deque.isEmpty()) {
      sb.append(deque.pollFirst());
    }

    System.out.println(sb);
  }
}
