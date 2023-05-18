package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10845_ {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    MyQueue myQueue = new MyQueue(N);

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      String command = st.nextToken();

      if ("push".equals(command)) {
        myQueue.push(Integer.parseInt(st.nextToken()));
      } else if ("pop".equals(command)) {
        sb.append(myQueue.pop()).append("\n");
      } else if ("size".equals(command)) {
        sb.append(myQueue.size()).append("\n");
      } else if ("empty".equals(command)) {
        sb.append(myQueue.isEmpty()).append("\n");
      } else if ("front".equals(command)) {
        sb.append(myQueue.front()).append("\n");
      } else if ("back".equals(command)) {
        sb.append(myQueue.back()).append("\n");
      }
    }

    System.out.println(sb);

    br.close();
  }

  static class MyQueue {
    int size;
    int[] datum;

    int head;
    int tail;

    MyQueue(int queueSize) {
      this.size = 0;
      this.head = 0;
      this.tail = 1;
      this.datum = new int[queueSize];
    }

    public int isEmpty() {
      return (this.head + 1) % datum.length == this.tail ? 1 : 0;
    }

    public int isFull() {
      return this.head == this.tail ? 1 : 0;
    }

    public void push(int data) {
      if (isFull() == 0) {
        datum[this.tail] = data;
        this.tail = (this.tail + 1) % datum.length;
        this.size++;
      }
    }

    public int pop() {
      int data = -1;

      if (isEmpty() == 0) {
        this.head = (this.head + 1) % datum.length;
        data = datum[this.head];
        this.size--;
      }

      return data;
    }

    public int back() {
      int data = -1;

      if (isEmpty() == 0) {
        data = datum[this.tail - 1];
      }

      return data;
    }

    public int front() {
      int data = -1;

      if (isEmpty() == 0) {
        data = datum[this.head + 1];
      }

      return data;
    }

    public int size() {
      return this.size;
    }
  }
}
