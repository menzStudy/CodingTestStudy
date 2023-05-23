package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _11286_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> plus = new PriorityQueue<>();
		PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int X = Integer.parseInt(br.readLine());

			if (X > 0) {
				plus.add(X);
			} else if (X < 0) {
				minus.add(X);
			}


			// X가 0이고 양측의 큐가 둘다 비어 있지 않으면 절대값 비교 시작
			if (X == 0 && !plus.isEmpty() && !minus.isEmpty()) {
				// 절대값이 동일한 경우는 더 작은 값인 minus에서 poll
				if (Math.abs(plus.peek()) == Math.abs(minus.peek())) {
					sb.append(minus.poll()).append("\n");
					continue;
				}

				// 절대값이 plus쪽이 더 큰 경우 minus에서 poll
				if (Math.abs(plus.peek()) > Math.abs(minus.peek())) {
					sb.append(minus.poll()).append("\n");
					continue;
				}

				// 절대값이 minus가 더 큰 경우 plus에서 poll
				if (Math.abs(plus.peek()) < Math.abs(minus.peek())) {
					sb.append(plus.poll()).append("\n");
					continue;
				}
			}


			// X가 0이고, plus 큐가 비어 있고 minus가 비어 있지 않다면 minus poll
			if (X == 0 && plus.isEmpty() && !minus.isEmpty()) {
				sb.append(minus.poll()).append("\n");
				continue;
			}

			// X가 0이고, minus가 큐가 비어 있고 plus 비어 있지 않다면 plus poll
			if (X == 0 && !plus.isEmpty() && minus.isEmpty()) {
				sb.append(plus.poll()).append("\n");
				continue;
			}

			// 만약 둘다 비어있다면 0을 반환
			if (X == 0 && plus.isEmpty() && minus.isEmpty()) {
				sb.append(0).append("\n");
				continue;
			}

		}

		System.out.println(sb);
	}

}
