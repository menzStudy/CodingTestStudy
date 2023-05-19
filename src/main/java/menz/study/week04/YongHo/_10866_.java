package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10866_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Deq deq = new Deq(N);

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      String command = st.nextToken();
      if ("push_back".equals(command)) {
        deq.push_back(Integer.parseInt(st.nextToken()));
      } else if ("push_front".equals(command)) {
        deq.push_front(Integer.parseInt(st.nextToken()));
      } else if ("size".equals(command)) {
        sb.append(deq.size()).append("\n");
      } else if ("pop_front".equals(command)) {
        sb.append(deq.pop_front()).append("\n");
      } else if ("pop_back".equals(command)) {
        sb.append(deq.pop_back()).append("\n");
      } else if ("front".equals(command)) {
        sb.append(deq.front()).append("\n");
      } else if ("back".equals(command)) {
        sb.append(deq.back()).append("\n");
      } else if ("empty".equals(command)) {
        sb.append(deq.empty()).append("\n");
      }

    }

    System.out.println(sb);
    br.close();
  }

  static class Deq {
    private int size;
    private final int[] datum;

    int head = 0;
    int tail = 1;

    Deq(int size) {
      this.size = 0;
      this.datum = new int[size * 2];
    }

    public void push_front(int data) {
      datum[this.head] = data;
      this.head = (this.head + datum.length - 1) % datum.length;
      size++;
    }

    public void push_back(int data) {
      datum[this.tail] = data;
      this.tail = (this.tail + 1) % datum.length;
      size++;
    }

    /** 들어있는 정수 없으면 -1 */
    public int pop_front() {
      int data = -1;

      if (size != 0) {
        this.head = (this.head + 1) % datum.length;
        data = datum[this.head];
        size--;
      }

      return data;
    }

    /** 들어있는 정수 없으면 -1 */
    public int pop_back() {
      int data = -1;

      if (size != 0) {
        this.tail = (this.tail + datum.length - 1) % datum.length;
        data = datum[this.tail];
        size--;
      }

      return data;
    }

    /** size 출력 */
    public int size() {
      return size;
    }

    /** 비어있으면 1, 아니면 0 */
    public int empty() {
      return size == 0 ? 1 : 0;
    }

    /** 들어있는 정수 없으면 -1 */
    public int front() {
      int data = -1;

      if (size != 0) {
        int idx = (this.head + 1) % datum.length;
        data = datum[idx];
      }

      return data;
    }

    /** 들어있는 정수 없으면 -1 */
    public int back() {
      int data = -1;

      if (size != 0) {
        int idx = (this.tail + datum.length - 1) % datum.length;
        data = datum[idx];
      }

      return data;
    }
  }
}
