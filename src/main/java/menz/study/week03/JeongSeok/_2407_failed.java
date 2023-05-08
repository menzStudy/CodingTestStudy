package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2407_failed {

	static int N,M;

	private static long getNFactorial(long k) {
		if (k == (N - M) + 1) {
			return k;
		}
		return getNFactorial(k - 1) * k;
	}

	private static long getMFactorial(long k) {
		if (k == 1) {
			return 1;
		}
		return getMFactorial(k - 1) * k;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		long result = getNFactorial(N) / getMFactorial(M);

		System.out.println(result);
	}
}
