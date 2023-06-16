package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<int[]> list = new ArrayList<>();
		int root = 1;

		for (int i = 1; i <= 7; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] pair = new int[2];
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (y == root) {
				pair[0] = y;
				pair[1] = x;

				root = x;
				list.add(pair);
				continue;
			}

			pair[0] = x;
			pair[1] = y;
			list.add(pair);
		}

		// 정렬
	}

}
