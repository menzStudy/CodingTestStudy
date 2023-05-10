package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17087_ {

	static int N, S;

	private static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		// 수빈이와 초당 X + D or X - D 만큼 이동할 수 있다.
		// 이 말은 수빈이와 동생들 거리를 뺀 후 최대 이동 가능 거리를 구해야한다.
		for (int i = 0; i < N; i++) {
			arr[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
		}

		int gcdValue = arr[0];

		for(int i = 1; i < N; i++) {
			// 뺀 거리에 대한 최대 이동 거리를 구하기 위해선 각 거리마다의 최대 공약수를 구해주면 된다.
			gcdValue = gcd(gcdValue, arr[i]);
		}
	}

}
