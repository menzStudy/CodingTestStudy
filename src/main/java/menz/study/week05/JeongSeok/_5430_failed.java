package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _5430_failed {

	static int countCommand(String command, char findCommand) {
		int count = 0;

		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == findCommand) {
				count++;
			}
		}

		return count;
	}

	static boolean calculateRCount(int rCount) {
		return rCount % 2 != 0;
	}

	static String printReverse(Deque<Integer> deque) {
		StringBuilder sb = new StringBuilder();

		if (deque.isEmpty()) {
			return "[]";
		}

		// 결과 출력
		sb.append("[");
		sb.append(deque.pollLast());
		while (!deque.isEmpty()) {
			sb.append(",").append(deque.pollLast());
		}
		sb.append("]");

		return sb.toString();
	}

	static String printNotReverse(Deque<Integer> deque) {
		StringBuilder sb = new StringBuilder();

		if (deque.isEmpty()) {
			return "[]";
		}

		// 결과 출력
		sb.append("[");
		sb.append(deque.pollFirst());
		while (!deque.isEmpty()) {
			sb.append(",").append(deque.pollFirst());
		}
		sb.append("]");

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			// init
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			for (int i = 0; i < N; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}


			// 1. RD 각 갯수 카운팅
			int rCount = countCommand(command, 'R');
			int dCount = countCommand(command, 'D');

			// 2. R의 갯수를 2로 나누고 짝수면 안뒤집고, 홀수면 뒤집자
			// false = 안뒤집음, true = 뒤집음
			boolean isReverse = calculateRCount(rCount);

			// 3. 뒤집힌 여부를 판단 후 D의 갯수만큼 명령어 실행
			if (isReverse) {
				while (dCount-- > 0) {
					if (deque.isEmpty()) {
						System.out.println("error");
						break;
					}
					deque.pollLast();
				}

				if (dCount == 0) {
					continue;
				}

				// 결과 출력
				System.out.println(printReverse(deque));
			} else {
				while (dCount-- > 0) {
					if (deque.isEmpty()) {
						System.out.println("error");
						break;
					}
					deque.pollFirst();
				}

				if (dCount == 0) {
					continue;
				}

				// 결과 출력
				System.out.println(printNotReverse(deque));
			}
		}
	}

}
