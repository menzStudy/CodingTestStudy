package menz.study.week04.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1021_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		LinkedList<Integer> deque = new LinkedList<>();

		int count = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] targetArr = new int[M];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			targetArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}

		for (int i = 0; i < M; i++) {
			int targetIdx = deque.indexOf(targetArr[i]);
			int halfIdx;

			if (deque.size() % 2 == 0) {
				halfIdx = deque.size() / 2 - 1;
			} else {
				halfIdx = deque.size() / 2;
			}

			// 절반보다 아래면 앞에서 빼는 횟수가 더 적기 떄문
			if (targetIdx <= halfIdx) {
				for (int j = 0; j < targetIdx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			} else {
				// 마찬가지로 절반보다 위인 경우 뒤에서 뺴는 횟수가 더 적기 때문
				for (int j = 0; j < deque.size() - targetIdx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			deque.pollFirst();
		}

		System.out.println(count);

	}

}
