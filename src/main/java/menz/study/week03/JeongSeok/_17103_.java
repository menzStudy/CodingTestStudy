package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17103_ {

	static final int MAX_LENGTH = 1_000_001;
	static boolean[] notPrime = new boolean[MAX_LENGTH + 1];
	static StringBuilder sb = new StringBuilder();

	// false = 소수, true = 소수가 아님
	static {
		notPrime[0] = notPrime[1] = true;

		for (int i = 2; i <= MAX_LENGTH; i++) {
			if (notPrime[i]) {
				continue;
			}
			for (int j = i + i; j <= MAX_LENGTH; j += i) {
				notPrime[j] = true;
			}
		}
	}

	// 입력받은 수를 절반으로 나눠 골드바흐 파티션을 구한다.
	private static int findGoldbachPartition(int n) {
		int count = 0;

		int left = n / 2;
		int right = n / 2;

		while (left != 1 && right != n) {
			if (!notPrime[left] && !notPrime[right]) {
				count++;
				left--;
				right++;
			} else {
				left--;
				right++;
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < T; i++) {
			sb.append(findGoldbachPartition(arr[i])).append("\n");
		}
		System.out.println(sb);
	}

}
