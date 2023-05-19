package menz.study.week04.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1021_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CircularQueue dq = new CircularQueue();
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
                dq.offer(i, n);
        }

        st = new StringTokenizer(br.readLine(), " ");
        while (m > 0) {
            int num = Integer.parseInt(st.nextToken());

            if(dq.peek() == num) {
                m--;
                dq.poll();
                continue;
            }

            int idx = dq.indexOf(num);
            int mid = dq.size() % 2 == 0 ? dq.size() / 2  - 1: dq.size() / 2;

            for (int i = 0; i < n; i++) {
                if(idx <= mid) {
                    if(num == dq.peek()) {
                        dq.poll();
                        m--;
                        break;
                    }
                    dq.moveLeft();
                    cnt++;
                } else {
                    if(num == dq.peek()) {
                        dq.poll();
                        m--;
                        break;
                    }
                    dq.moveRight();
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

class Node3 {
    int data;
    Node3 next;
    Node3 prev;

    public Node3(int data, Node3 next, Node3 prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class CircularQueue {
    Node3 head;
    Node3 tail;
    private int size = 0;

    public CircularQueue() {}

    public void offer(int data, int last) {
        if(this.head == null) {
            Node3 newNode = new Node3(data, null, null);
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node3 pre = this.tail;
            this.tail = new Node3(data, null, pre);
            this.head.prev = tail;

            if(this.head.next == null) {
                this.head.next = tail;
            } else {
                Node3 cur = this.head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = tail;
            }
        }

        if(data == last) {
            this.tail.next = this.head;
        }
        size++;
    }

    public int poll() {
        int data = 0;
        if(this.head != null) {
            data = this.head.data;
            this.head = this.head.next;
            this.tail.next = this.head;
            this.head.prev = this.tail;
        }

        size--;
        return data;
    }

    public void moveLeft() {
        if(this.head != null) {
            Node3 tmp = this.head;
            this.tail = tmp;
            this.head = this.head.next;
            this.tail.next = this.head;
            this.head.prev = this.tail;
        }
    }

    public void moveRight() {
        if(this.head != null) {
            Node3 tmp = this.tail;
            this.head = tmp;
            this.tail = tmp.prev;
            this.head.prev = this.tail;
            this.tail.next = this.head;
        }
    }

    public int peek() {
        if(this.head != null) {
            return this.head.data;
        }

        return -1;
    }

    public int indexOf(int data) {
        int idx = 0;
        if(this.head.next != null) {
            Node3 cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
                idx++;
                if(cur.data == data) break;
            }
        }
        return idx;
    }

    public int size() {
        return this.size;
    }
}
