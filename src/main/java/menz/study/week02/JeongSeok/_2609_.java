package menz.study.week02.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609_ {

	// 유클리드 호제법을 이용한 최대공약수 구하기
	// 조건은 a > b 경우 유클리즈 호제법 성립 가능
	static int gcd(int a, int b) {
		int r = 0;

		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}

		return a;
	}

	// 최소공배수의 성질 중 두 수 a와 b의 최소공배수는 a와 b의 곱을 a와 b의 최대공약수를 나눈 것과 같다. 라는 성질을 이용하여 풀이
	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		System.out.println(gcd(N, M));
		System.out.println(lcm(N, M));
	}

}
