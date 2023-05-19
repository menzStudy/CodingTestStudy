package menz.study.week04.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10866_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque q = new Deque();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push_front":
                    q.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    q.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(q.pop_front() + "\n");
                    break;
                case "pop_back":
                    sb.append(q.pop_back() + "\n");
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

class Deque {
    Node2 head;
    Node2 tail;
    private int size = 0;

    public Deque() {}

    public int empty() {
        return this.head == null ? 1 : 0;
    }

    public void push_front(int data) {
        if(this.head == null) {
            this.head = new Node2(data, null, null);
            this.tail = this.head;
        } else {
            Node2 next = this.head;
            this.head = new Node2(data, next, null);
            next.prev = this.head;
        }
        this.size++;
    }

    public void push_back(int data) {
        if(this.head == null) {
            this.head = new Node2(data, null, null);
            this.tail = this.head;
        } else {
            Node2 pre = this.tail;
            this.tail.next = new Node2(data, null, pre);
            this.tail = this.tail.next;
        }
        this.size++;
    }

    public int pop_front() {
        if(empty() == 1) return -1;

        int data = this.head.data;
        if(this.head.next != null) {
            this.head = this.head.next;
            this.head.prev = null;
        } else {
            this.head = null;
            this.tail = null;
        }

        this.size--;

        return data;
    }

    public int pop_back() {
        if(empty() == 1) return -1;

        int data = this.tail.data;

        if(this.tail.prev != null) {
            this.tail = this.tail.prev;
            this.tail.next = null;
        } else {
            this.tail = null;
            this.head = null;
        }
        this.size--;

        return data;
    }

    public int front() {
        return empty() == 1 ? -1 : this.head.data;
    }

    public int back() {
        return empty() == 1 ? -1 : this.tail.data;
    }

    public int size() {
        return this.size;
    }
}

class Node2 {
    int data;
    Node2 next;
    Node2 prev;

    public Node2(int data, Node2 next, Node2 prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
