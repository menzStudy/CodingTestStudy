package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;
import java.util.StringTokenizer;

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