package menz.study.week07.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15651_ {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void dfs(int depth) {
		if (depth == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= N; i++) {
				arr[depth] = i;
				dfs(depth + 1);
				arr[depth] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M + 1];


		dfs(1);
		System.out.println(sb);

	}
}
