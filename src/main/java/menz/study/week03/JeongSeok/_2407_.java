package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 문제 풀이
 *
 * N = 100, M = 6 경우일 때 nCm 를 수식으로 나타내어 결과값인 1192052400 를 출력하는 문제
 *
 * 이를 수식에 맞춰서 풀면
 * N! / M!(N-M)! 공식으로 풀 수 있는데, long 타입으로 풀었을 당시 N = 100, M = 50인 경우 숫자가 너무 커서 long 타입으로 표현할 수 없었고, BigInteger 클래스를 사용함
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

public class _2407_ {

	static BigInteger N,M;

	private static BigInteger getNFactorial(BigInteger n) {
		if (Objects.equals(n, N.subtract(M).add(BigInteger.ONE))) {
			return n;
		}
		return getNFactorial(n.subtract(BigInteger.ONE)).multiply(n);
	}

	private static BigInteger getMFactorial(BigInteger m) {
		if (Objects.equals(m, BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		return getMFactorial(m.subtract(BigInteger.ONE)).multiply(m);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = new BigInteger(st.nextToken());
		M = new BigInteger(st.nextToken());

		BigInteger result = getNFactorial(N).divide(getMFactorial(M));

		System.out.println(result);
	}

}