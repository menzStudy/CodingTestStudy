package menz.study.week02.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182_ {

	static int N, S, answer;
	static int[] nums;

	static void rec_func(int k, int value) {
		// N + 1로 배열의 길이를 만들었기 때문에 조건문도 N + 1로 변경해줘야 한다.
		if (k == N + 1) {
			if (value == S) {
				answer++;
			}
		} else { // K번째 원소를 포함시킬지 결정하고 재귀호출

			// 포함시킬 경우
			// K번째 원소까지 다 더한 수
			rec_func(k + 1, value + nums[k]);

			// 포함시키지 않을 경우
			// K - 1번째 원소까지 다 더한 수
			rec_func(k + 1, value);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		answer = 0;

		// 1부터 인덱스 계산하기 위해 N + 1
		nums = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}


		rec_func(1, 0);

		// 아무것도 고르지 않은 상태도 포함되기 때문에 공집합인 경우 answer-- 해준다.
		if (S == 0) {
			answer--;
		}


	}

}
