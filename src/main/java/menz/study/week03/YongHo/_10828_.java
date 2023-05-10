package menz.study.week03.YongHo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10828_ {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    // push, pop, size, empty, top
    MyStack myStack = new MyStack(N);

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      String command = st.nextToken();

      if ("push".equals(command)) {
        myStack.push(Integer.parseInt(st.nextToken()));
      } else if ("pop".equals(command)) {
        sb.append(myStack.pop()).append("\n");
      } else if ("size".equals(command)) {
        sb.append(myStack.size()).append("\n");
      } else if ("empty".equals(command)) {
        sb.append(myStack.isEmpty()).append("\n");
      } else {
        sb.append(myStack.top()).append("\n");
      }
    }

    System.out.println(sb);

    br.close();
  }

  static class MyStack {
    int curSize;
    int[] datum;

    MyStack(int stackSize) {
      this.curSize = 0;
      this.datum = new int[stackSize];
    }

    public int isEmpty() {
      return curSize == 0 ? 1 : 0;
    }

    public int isFull() {
      return curSize == datum.length ? 1 : 0;
    }

    public void push(int data) {
      if (isFull() == 0) {
        datum[curSize++] = data;
      }
    }

    public int pop() {
      int data = -1;

      if (isEmpty() == 0) {
        data = datum[--this.curSize];
      }

      return data;
    }

    public int top() {
      int data = -1;

      if (isEmpty() == 0) {
        data = datum[this.curSize - 1];
      }

      return data;
    }

    public int size() {
      return this.curSize;
    }
  }
}
