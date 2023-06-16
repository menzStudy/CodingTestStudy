package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _5567_ {

	static int N, pair, count;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 입력받는다
		N = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];


		for (int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			arr[from][to] = arr[to][from] = 1;
		}

		// 원할한 친구 계산을 위해서 상근이 자기 자신도 1이라고 칭함
		arr[1][1] = 1;

		// 2. dfs 순회
		dfs();


		System.out.println(count);
	}

	public static void dfs() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		visited[1] = true;
		count = 0;

		while (!stack.isEmpty()) {
			int cur = stack.pop();

			for (int i = 2; i <= N; i++) {
				if (arr[cur][1] == 1 && arr[cur][i] == 1 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}

}
