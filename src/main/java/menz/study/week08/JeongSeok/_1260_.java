package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260_ {

	static int node, edge, start;
	static int[][] arr;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		// 1. 입력을 받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		// 2. 2차원 배열로 나타낸다.
		arr = new int[node + 1][node + 1];
		visited = new boolean[node+1];

		for(int i = 0 ; i < edge ; i ++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] =  1;
		}

		// 3. dfs 탐색
		dfs(1);
		sb.append("\n");

		// 3-1. 탐색 종료 후 방문 배열 초기화 or 재생성
		visited = new boolean[node+1];

		// 4. bfs 탐색
		bfs(start);

		// 5. 종료
		System.out.println(sb);
	}

	public static void dfs(int start) {

		visited[start] = true;

		sb.append(start).append(" ");

		for(int i = 0 ; i <= node; i++) {
			if(arr[start][i] == 1 && !visited[i])
				dfs(i);
		}
	}

	public static void bfs(int start) {
		queue.add(start);

		visited[start] = true;

		while(!queue.isEmpty()) {

			start = queue.poll();

			sb.append(start).append(" ");

			for(int i = 1 ; i <= node ; i++) {
				if(arr[start][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
