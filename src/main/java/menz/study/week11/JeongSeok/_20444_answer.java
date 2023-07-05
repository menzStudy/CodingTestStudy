package menz.study.week11.JeongSeok;

import java.io.*;
import java.util.*;

public class _20444_answer {

	static long N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());

		long left = 0;
		long right = N / 2;

		while (left <= right) {
			long row = (left + right) / 2;
			long col = N - row;

			long total = (row + 1) * (col + 1);

			if (total == K) {
				System.out.println("YES");
				return;
			} else if (total > K) {
				right = row - 1;
			} else if (total < K) {
				left = row + 1;
			}
		}

		System.out.println("NO");

	}

}
