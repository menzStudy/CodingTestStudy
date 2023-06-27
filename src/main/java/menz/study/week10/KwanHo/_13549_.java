package menz.study.week10.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13549_ {

    private static boolean[] positionMap = new boolean[1_000_01];
    private static final int max = 1_000_00;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int n, int k) {
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(n, 0));
        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Person cur = q.poll();
            positionMap[cur.pos] = true;

           if(cur.pos == k) {
               min = Math.min(min, cur.sec);
           }

           if(cur.pos * 2 <= max && !positionMap[cur.pos * 2]) {
               q.offer(new Person(cur.pos * 2, cur.sec));
           }

            if (cur.pos + 1 <= max && !positionMap[cur.pos + 1]) {
                q.offer(new Person(cur.pos + 1, cur.sec + 1));
            }

            if (cur.pos - 1 >= 0 && !positionMap[cur.pos - 1]) {
                q.offer(new Person(cur.pos - 1, cur.sec + 1));
            }
        }

        return min;
    }
}

class Person {
    int pos, sec;

    public Person(int pos, int sec) {
        this.pos = pos;
        this.sec = sec;
    }
}
