package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 틀린 이유
 * 수빈이의 거리를 고려하지 않고, 단순히 동생들끼리의 거리 차이를 각각 구한 후 구한 값에서 최대공약수를 구했기 때문
 * 테스트 케이스는 통과되었지만, 제출시 탈락
 */
public class _17087_failed {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		if (arr.length != 1) {
			int gcdValue = arr[1] - arr[0];

			// 수빈이의 위치값을 고려하지 않고 동생들끼리의 거리를 뺀 후 최대공약수를 구한다.
			for(int i = 2; i < N; i++) {
				gcdValue = gcd(gcdValue, arr[i] - arr[i - 1]);
			}

			System.out.println(gcdValue);
		} else {
			System.out.println(Math.abs(arr[0] - S));
		}
	}

	private static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
