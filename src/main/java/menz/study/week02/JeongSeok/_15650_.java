package menz.study.week02.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_ {

	static int N, M;

	static int[] selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void rec_func(int depth) {
		if (depth == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			int start = selected[depth - 1];
			if (start == 0) {
				start = 1;
			}
			for (int i = start; i <= N; i++) {
				if (!visited[i]) {
					selected[depth] = i;
					visited[i] = true;
					rec_func(depth + 1);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M + 1];
		visited = new boolean[N + 1];

		rec_func(1);

		System.out.println(sb);

	}

}
