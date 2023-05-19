package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _1021_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] nums = new int[M];

    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < M; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    LinkedList<Integer> list = new LinkedList<>();

    IntStream.rangeClosed(1, N).boxed().forEach(list::addLast);
    int answer = 0;

    for (int i = 0; i < M; i++) {
      int target = nums[i];
      int idx = list.indexOf(target);

      if (list.size() % 2 == 0) {
        if (idx < list.size() / 2) {
          while (idx-- > 0) {
            list.addLast(list.removeFirst());
            answer++;
          }
        } else {
          int count = list.size() - idx;
          while (count-- > 0) {
            list.addFirst(list.removeLast());
            answer++;
          }
        }
      } else {
        if (idx <= list.size() / 2) {
          while (idx-- > 0) {
            list.addLast(list.removeFirst());
            answer++;
          }
        } else {
          int count = list.size() - idx;
          while (count-- > 0) {
            list.addFirst(list.removeLast());
            answer++;
          }
        }
      }
      list.removeFirst();
    }

    System.out.println(answer);
    br.close();
  }
}
