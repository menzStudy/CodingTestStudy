package menz.study.week02.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 메모리 초과로 인한 실패 코드
 */

public class _2981_memory {

	static int N;
	static int min;
	static int[] elements;

	static int[][] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		elements = new int[N];

		for (int i = 0; i < N; i++) {
			elements[i] = Integer.parseInt(br.readLine());
		}

		// 원소중에서 제일 작은 값 찾기
		min = findMinValue();

		// 원소들을 하나씩 순회하면서 2부터 제일 작은 값까지 나눈 나머지를 저장
		result = new int[N][min + 1];
		saveResult();

		// result 배열을 순회하면서 결과가 같은 값을 찾기
		findSameResult();

		System.out.println(sb);

	}

	public static int findMinValue() {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			if (min > elements[i]) {
				min = elements[i];
			}
		}

		return min;
	}

	public static void saveResult() {
		for (int i = 0; i < N; i++) {
			for (int j = 2; j <= min; j++) {
				result[i][j] = elements[i] % j;
			}
		}
	}

	public static void findSameResult() {

		for (int j = 2; j <= min; j++) {
			int value = result[0][j];
			boolean flag = true;

			for (int i = 0; i < N; i++) {
				if (value != result[i][j]) {
					flag = false;
					break;
				}
			}

			if (flag) {
				sb.append(j).append(" ");
			}
		}

	}

}
