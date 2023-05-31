package menz.study.week06.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1912_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[] arr = new int[T];
		int[] dp = new int[T];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 반복문 순회시 이전 값을 참조하기 위해서 맨처음 요소는 초기화
		dp[0] = arr[0];


		// 배열에 양끝 음수, 중간에 음수가 있어도 처리 가능
		for (int i = 1; i < T; i++) {
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
		}

		// 초기화하는 이유는 세번째 테스트 케이스 때문에 초기화
		// 만약 0으로 초기화 된다면 -1 보다 0이 더 크기 때문에 최대값을 뽑을 수 없음
		int max = dp[0];

		for (int i = 0; i < T; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}

		System.out.println(max);
	}
}
