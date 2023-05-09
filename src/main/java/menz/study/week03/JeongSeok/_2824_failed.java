package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2824_failed {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static final int MAX_LENGTH = 9;

	private static BigInteger gcd(BigInteger a, BigInteger b) {
		BigInteger max = a.max(b);
		BigInteger min = a.min(b);

		return max.gcd(min);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		BigInteger[] n = new BigInteger[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			n[i] = new BigInteger(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		BigInteger[] m = new BigInteger[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			m[i] = new BigInteger(st.nextToken());
		}

		BigInteger result1 = BigInteger.ONE;
		BigInteger result2 = BigInteger.ONE;

		// N개의 수를 곱한다.
		for (int i = 0; i < N; i++) {
			result1 = result1.multiply(n[i]);
		}

		for (int i = 0; i < M; i++) {
			result2 = result2.multiply(m[i]);
		}

		BigInteger gcd = gcd(result1, result2);
		String string = gcd.toString();

		if (string.length() > 10) {
			int diff = string.length() - MAX_LENGTH;

			for (int i = diff; i < string.length(); i++) {
				sb.append(string.charAt(i));
			}
		} else {
			System.out.println(string);
		}

		System.out.println(sb);
	}
}
