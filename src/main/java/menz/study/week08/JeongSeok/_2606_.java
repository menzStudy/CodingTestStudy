package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2606_ {

	static int N, pair;
	static int[][] arr;
	static boolean[] visited;
	static Stack<Integer> stack;


	public static void main(String[] args) throws IOException {

		// 1. 입력을 받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[start][end] = arr[end][start] = 1;
		}

		stack = new Stack<>();

		int result = dfs(1);
		System.out.println(result);
	}

	public static int dfs(int start) {
		int count = 0;
		stack.push(start);
		visited[start] = true;

		while (!stack.isEmpty()) {
			int cur = stack.pop();

			for (int i = 1; i <= N; i++) {
				if (arr[cur][i] != 0 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
					count++;
				}
			}
		}

		return count;
	}

}
