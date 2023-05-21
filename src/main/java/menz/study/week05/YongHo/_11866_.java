package menz.study.week05.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _11866_ {
  static int N;
  static int K;

  public static void main(String[] args) throws IOException {
    input();
    solve();
  }

  private static void solve() {
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    Queue<Integer> queue = new LinkedList<>();
    IntStream.rangeClosed(1, N).boxed().forEach(queue::offer);

    while (!queue.isEmpty()) {
      for (int i = 1; i < K; i++) {
        queue.offer(queue.poll());
      }
      sb.append(queue.poll()).append(", ");
    }

    sb.delete(sb.length() - 2, sb.length());
    sb.append(">");

    System.out.println(sb);
  }

  private static void input() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
