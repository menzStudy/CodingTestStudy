package menz.study.week10.KwanHo;

import java.io.*;
import java.util.*;

public class _9370_ {
    static int v,e,t;
    static int dist[];
    static int INF = 100000000;
    static List<List<Node>>list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0; i<testCnt;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            dist = new int[v+1];
            Arrays.fill(dist,INF);
            list = new ArrayList<>();
            for(int j = 0; j<v+1;j++){
                list.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int j = 0; j < e;j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if((u == g && v ==h) || (u == h && v == g)){
                    list.get(u).add(new Node(v,weight * 2 - 1));
                    list.get(v).add(new Node(u,weight * 2 - 1));
                }else{
                    list.get(u).add(new Node(v,weight * 2));
                    list.get(v).add(new Node(u,weight * 2));
                }
            }
            ArrayList<Integer> candidate = new ArrayList<>();
            for(int j = 0; j<t;j++){
                candidate.add(Integer.parseInt(br.readLine()));
            }
            dijkstra(start);

            Collections.sort(candidate);
            for(int num : candidate){
                if(dist[num] % 2 == 1) sb.append(num + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        boolean[] visit = new boolean[v+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        dist[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visit[cur.end]){
                visit[cur.end] = true;

                for(Node node : list.get(cur.end)){
                    if(!visit[node.end] && dist[node.end] > dist[cur.end] + node.weight){
                        dist[node.end] = dist[cur.end] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    }
}

class Node{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}