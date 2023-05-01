package menz.study.week01.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649_ {

	static int N, M;
	static int[] selected;
	static int[] used;
	static StringBuilder sb = new StringBuilder();

	static void rec_func(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int cand = 1; cand <= N; cand++) {
				if (used[cand] == 1) {
					continue;
				}

				selected[k] = cand;
				used[cand] = 1;
				rec_func(k + 1);
				selected[k] = 0;
				used[cand] = 0;

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M + 1];
		used = new int[N + 1];


		rec_func(1);
		System.out.println(sb.toString());
	}

}