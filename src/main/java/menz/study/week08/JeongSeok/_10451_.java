package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10451_ {

	static int[][] arr;
	static boolean[] visited;
	static int N;
	static Stack<Integer> stack;
	static StringBuilder sb = new StringBuilder();



	public static void main(String[] args) throws IOException {

		// 1. 입력을 받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			stack = new Stack<>();
			int count = 0;


			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				int value = Integer.parseInt(st.nextToken());
				arr[j][value] = 1;
			}


			// 2. dfs 순회
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					count++;
					stack.push(j);
					visited[j] = true;
					dfs();
				}
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

	public static void dfs() {

		while (!stack.isEmpty()) {
			int cur = stack.pop();

			for (int i = 1; i <= N; i++) {
				if (arr[cur][i] != 0 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
			}
		}
	}
}
