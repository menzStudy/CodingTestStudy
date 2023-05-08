package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 풀이
 *
 * N = 100, M = 6 경우일 때 nCm 를 수식으로 나타내어 결과값인 1192052400 를 출력하는 문제
 *
 * 이를 수식에 맞춰서 풀면
 * N! / M!(N-M)! 공식으로 풀 수 있는데, 숫자가 너무 크니 우선 long 타입으로 문제를 풀이했음
 *
 * 입출력 예시로 1192052400 를 도출하는 과정을 살펴보면
 * N! = 100 * 99 * 98 * 97 * 96 * 95 * 94 * ..... 6 * 5 * 4 * 3 * 2 * 1
 * M! = 6 * 5 * 4 * 3 * 2 * 1
 * (N-M)! = 94 * 93 * 92 * 91 * 90 * ....... 6 * 5 * 4 * 3 * 2 * 1
 *
 * 이렇게 나타낼 수 있다. 여기서 N!의 94이하의 팩토리얼은 (N-M)!과 동일한 값이고 약분이 가능해진다.
 * 그렇기 때문에 100 * 99 * 98 * 97 * 96 * 95 / 6 * 5 * 4 * 3 * 2 * 1 값을 구하면 된다.
 *
 */

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
