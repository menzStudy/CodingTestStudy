package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class _2164_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Queue<Integer> queue = new LinkedList<>();

    IntStream.rangeClosed(1, N).boxed().forEach(queue::add);

    boolean flag = true;
    while (queue.size() != 1) {
      if (flag) {
        queue.poll();
        flag = !flag;
      } else {
        queue.offer(queue.poll());
        flag = !flag;
      }
    }

    System.out.println(queue.poll());
  }
}
