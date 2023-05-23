package menz.study.week05.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        this.heap.add(data);

        int cur = this.heap.size() - 1;
        while (cur > 1 && this.heap.get(cur / 2) > this.heap.get(cur)) {
            int parentValue = this.heap.get(cur / 2);
            this.heap.set(cur / 2, data);
            this.heap.set(cur, parentValue);

            cur /= 2;
        }
    }

    public int delete() {
        if(this.heap.size() == 1) {
            return 0;
        }

        int target = this.heap.get(1);

        this.heap.set(1, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        int cur = 1;
        while (true) {
            int leftChildIdx = cur * 2;
            int rightChildIdx = cur * 2 + 1;
            int targetIdx = 0;

            if(rightChildIdx < this.heap.size()) {
                targetIdx = this.heap.get(leftChildIdx) < this.heap.get(rightChildIdx) ?
                        leftChildIdx : rightChildIdx;
            } else if(leftChildIdx < this.heap.size()) {
                targetIdx = cur * 2;
            } else {
                break;
            }

            if(this.heap.get(cur) < this.heap.get(targetIdx)) {
                break;
            } else {
                int parentValue = this.heap.get(cur);
                this.heap.set(cur, heap.get(targetIdx));
                this.heap.set(targetIdx, parentValue);
                cur = targetIdx;
            }
        }

        return target;
    }
}

public class _1927_ {
    public static void main(String[] args) throws IOException {
        MinHeap minHeap = new MinHeap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int command = Integer.parseInt(br.readLine());

            if(command == 0) {
                sb.append(minHeap.delete() + "\n");
            } else {
                minHeap.insert(command);
            }
        }

        System.out.println(sb);
    }
}