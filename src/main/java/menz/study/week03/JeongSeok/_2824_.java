package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2824_ {

	static int N, M;
	static BigInteger[] n, m;
	static final int MAX_LENGTH = 9;


	// N, M을 입력받고 N, M개의 대한 데이터를 받기 위해 n,m 배열로 선언
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		n = new BigInteger[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			n[i] = new BigInteger(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		m = new BigInteger[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			m[i] = new BigInteger(st.nextToken());
		}
	}

	private static BigInteger gcd(BigInteger a, BigInteger b) {
		BigInteger max = a.max(b);
		BigInteger min = a.min(b);

		return max.gcd(min);
	}

	// A, B 각각 최대 공약수를 구한다.
	private static String calculateGCD() {
		BigInteger result1 = BigInteger.ONE;
		BigInteger result2 = BigInteger.ONE;

		// N개의 수를 곱한다.
		for (int i = 0; i < N; i++) {
			result1 = result1.multiply(n[i]);
		}

		for (int i = 0; i < M; i++) {
			result2 = result2.multiply(m[i]);
		}

		return gcd(result1, result2).toString();
	}

	public static void main(String[] args) throws IOException {

		init();
		String result = calculateGCD();

		// 길이가 9를 넘는 경우 그 만큼 빼준다.
		if (result.length() > MAX_LENGTH) {
			result = result.substring(result.length() - MAX_LENGTH);
		}

		System.out.println(result);
	}
}
