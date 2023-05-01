package menz.study.week01.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1978_ {

	static int count = 0;

	static boolean isPrimeNumber(int n) {
		// 1과 자기자신을 제외한 나머지 수로 나누어 떨어지지 않는 수
		boolean isPrime = true;

		if (n == 1) {
			return false;
		}

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (isPrimeNumber(Integer.parseInt(st.nextToken()))) {
				count++;
			}

		}

		System.out.println(count);
	}

}