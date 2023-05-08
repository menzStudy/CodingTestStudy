package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10974_ {

	static int N;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	private static void rec_func(int k, int depth) {
		if (depth == N + 1) {
			for (int i = 1; i <= N; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = i;
					rec_func(k + 1, depth + 1);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		result = new int[N + 1];
		visited = new boolean[N + 1];

		rec_func(1, 1);

		System.out.println(sb);
	}
}
