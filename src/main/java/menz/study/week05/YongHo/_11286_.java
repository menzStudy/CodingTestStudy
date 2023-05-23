package menz.study.week05.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11286_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    MinAbsHeap minAbsHeap = new MinAbsHeap(N);
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        sb.append(minAbsHeap.pop()).append("\n");
      } else {
        minAbsHeap.push(num);
      }
    }

    System.out.println(sb);
  }

  static class MinAbsHeap {
    int[] minHeap;
    int size;

    MinAbsHeap(int defaultSize) {
      this.size = 0;
      this.minHeap = new int[defaultSize * 2];
    }

    public void push(int x) {
      if (size == 0) {
        minHeap[++size] = x;
        return;
      }

      minHeap[++size] = x;
      int curPos = size;
      while (curPos > 1) {
        int parent = curPos / 2;
        if (Math.abs(minHeap[parent]) > Math.abs(minHeap[curPos])) swap(parent, curPos);
        else if (Math.abs(minHeap[parent]) == Math.abs(minHeap[curPos])
            && minHeap[parent] > minHeap[curPos]) swap(parent, curPos);
        curPos = parent;
      }
    }

    public int pop() {
      if (size == 0) {
        return 0;
      }

      int data = minHeap[1];
      minHeap[1] = minHeap[size--];
      int curPos = 1;
      while (curPos <= size) {
        int left = curPos * 2;
        int right = curPos * 2 + 1;
        if (right <= size) {
          int nextPos = left;
          if (Math.abs(minHeap[left]) > Math.abs(minHeap[right])) {
            nextPos = right;
          } else if (Math.abs(minHeap[left]) == Math.abs(minHeap[right])
              && minHeap[left] > minHeap[right]) {
            nextPos = right;
          }
          if (Math.abs(minHeap[curPos]) > Math.abs(minHeap[nextPos])) swap(curPos, nextPos);
          else if (Math.abs(minHeap[curPos]) == Math.abs(minHeap[nextPos])
              && minHeap[curPos] > minHeap[nextPos]) swap(curPos, nextPos);
          curPos = nextPos;
        } else if (left <= size) {
          if (Math.abs(minHeap[curPos]) > Math.abs(minHeap[left])) swap(curPos, left);
          else if (Math.abs(minHeap[curPos]) == Math.abs(minHeap[left])
              && minHeap[curPos] > minHeap[left]) swap(curPos, left);
          curPos = left;
        } else {
          break;
        }
      }

      return data;
    }

    private void swap(int idx1, int idx2) {
      int temp = minHeap[idx1];
      minHeap[idx1] = minHeap[idx2];
      minHeap[idx2] = temp;
    }
  }
}
