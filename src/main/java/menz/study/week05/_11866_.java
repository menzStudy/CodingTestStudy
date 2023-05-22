package menz.study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11866_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CircularLinkedList dq = new CircularLinkedList();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }

        sb.append('<');

        while (dq.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i == k - 1) {
                    sb.append(dq.poll() + ", ");
                } else {
                    dq.moveRight();
                }
            }
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append('>');
        System.out.println(sb);
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class CircularLinkedList {
    Node head;
    Node tail;
    private int size = 0;

    CircularLinkedList() {
    }

    public boolean isEmpty() {
        return this.head != null;
    }

    public void offer(int data) {
        if (this.head == null) {
            this.head = new Node(data, null, null);
            this.tail = this.head;
        } else {
            Node pre = this.tail;
            this.tail.next = new Node(data, null, pre);
            this.tail = this.tail.next;
        }
        this.size++;
    }

    public int poll() {
        this.size--;
        if(size == 0) {
            int data = this.head.data;
            this.head = null;
            this.tail = null;

            return data;
        }

        if (this.head != null) {
            int data = this.head.data;
            this.head = this.head.next;
            this.head.prev = this.tail;
            this.tail.next = this.head;

            return data;
        }

        return 0;
    }

    public void moveRight() {
        if (this.head != null) {
            Node cur = this.head;
            this.head = this.head.next;
            this.tail.next = cur;
            this.tail = this.tail.next;
        }
    }
}
