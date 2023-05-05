package menz.study.week02.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6588_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] prime = new boolean[1000001];

		prime[0] = prime[1] = true;

		for (int i = 2; i < prime.length; i++) {
			if (!prime[i]) {
				for (int j = i + i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}

		}


		while (true) {
			int N = Integer.parseInt(br.readLine());

			boolean flag = false;

			if (N == 0) {
				System.out.println(sb.toString());
				break;
			}

			for (int i = 2; i <= N / 2; i++) {
				if (!prime[i] && !prime[N - i]) {
					sb.append(N).append(" = ").append(i).append(" + ").append(N - i).append("\n");
					flag = true;
					break;
				}
			}

			if (!flag) {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			}
		}
	}

}
