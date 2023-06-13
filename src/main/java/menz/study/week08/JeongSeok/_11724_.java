package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11724_ {

	static int node, edge;
	static int[][] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1. 입력을 받는다.
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());

		arr = new int[node + 1][node + 1];
		visit = new boolean[node + 1];
		int count = 0;


		// 2. 2차원 배열로 나타낸다.
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		// 3. dfs 탐색
		for (int i = 1; i <= node; i++) {
			if (!visit[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
	}

	public static void dfs(int i) {
		visit[i] = true;

		for (int j = 1; j < node + 1; j++) {
			if (arr[i][j] == 1 && !visit[j]) {
				dfs(j);
			}
		}
	}

}
