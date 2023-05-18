package menz.study.week04.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class Queue2 {
    Node head;
    Node tail;

    private int size = 0;

    public Queue2() {
    }

    public int empty() {
        return this.head == null ? 1 : 0;
    }

    public void push(int data) {
        Node node = new Node(data, null);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        size++;
    }

    public int pop() {
        if (empty() == 1) {
            return -1;
        }

        Node pre = this.head;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = pre.next;
        }
        size--;

        return pre.data;
    }

    public int front() {
        return empty() == 1 ? -1 : this.head.data;
    }

    public int back() {
        return empty() == 1 ? -1 : tail.data;
    }

    public int size() {
        return this.size;
    }
}

public class _10845_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Queue2 q = new Queue2();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    q.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(q.pop() + "\n");
                    break;
                case "front":
                    sb.append(q.front() + "\n");
                    break;
                case "back":
                    sb.append(q.back() + "\n");
                    break;
                case "size":
                    sb.append(q.size() + "\n");
                    break;
                case "empty":
                    sb.append(q.empty() + "\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
