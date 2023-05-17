package menz.study.week04.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Queue<T> {
    List<Integer> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public Integer front() {
        return list.isEmpty() ? -1 : list.get(0);
    }

    public Integer back() {
        return list.isEmpty() ? -1 : list.get(list.size() - 1);
    }

    public Integer size() {
        return list.size();
    }

    public Integer empty() {
        return list.isEmpty() ? 1 : 0;
    }

    public Integer pop() {
        if(list.isEmpty()) {
            return -1;
        } else {
            int num = list.get(0);
            list.remove(0);
            return num;
        }
    }

}

class _18258_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new Queue<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    sb.append(q.front() + "\n");
                    break;
                case "back":
                    sb.append(q.back() + "\n");
                    break;
                case "empty":
                    sb.append(q.empty() + "\n");
                    break;
                case "pop":
                    sb.append(q.pop() + "\n");
                    break;
                case "size":
                    sb.append(q.size() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
