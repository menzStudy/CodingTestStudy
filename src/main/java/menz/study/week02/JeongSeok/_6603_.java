package menz.study.week02.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603_ {

	static int K;
	static int LOTTO_LENGTH = 6;
	static int[] S, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	static void rec_func(int k, int depth) {
		if (depth == LOTTO_LENGTH + 1) {
			for (int i = 1; i <= LOTTO_LENGTH; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = k; i <= K; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = S[i];
					rec_func(i, depth + 1);
					visited[i] = false;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			K = Integer.parseInt(st.nextToken());

			if (K == 0) {
				System.out.println(sb);
				break;
			}

			// 1부터 인덱스 계산하기 위해 K + 1
			S = new int[K + 1];
			for (int i = 1; i <= K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			result = new int[7];
			visited = new boolean[K + 1];

			rec_func(1, 1);
			sb.append("\n");
		}
	}

}
