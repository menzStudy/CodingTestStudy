package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_memory {

	static StringBuilder sb = new StringBuilder();

	static int fibo(int n) {
		if (n == 0) {
			sb.append("0");
			return 0;
		} else if (n == 1) {
			sb.append("1");
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			int N = Integer.parseInt(br.readLine());

			fibo(N);

			int zeroCount = 0;
			int oneCount = 0;

			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == '0') {
					zeroCount++;
				} else {
					oneCount++;
				}
			}

			sb = new StringBuilder();

			System.out.println(zeroCount + " " + oneCount);
		}
	}

}
