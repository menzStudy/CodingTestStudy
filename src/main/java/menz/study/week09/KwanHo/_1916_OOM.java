package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1916_OOM {

    private static ArrayList<Bus>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            Bus bus = new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            map[idx].add(bus);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(bfs(start, end));
    }

    private static int bfs(int start, int end) {
        Queue<Bus> q = new LinkedList<>();
        for(Bus bus : map[start]) {
            q.add(bus);
        }

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Bus cur = q.poll();
            if(cur.destination == end) {
                min = Math.min(min, cur.cost);
            }

            for(Bus bus : map[cur.destination]) {
                bus.cost += cur.cost;
                q.add(bus);
            }
        }

        return min;
    }
}

class Bus {
    int destination, cost;

    public Bus(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
}