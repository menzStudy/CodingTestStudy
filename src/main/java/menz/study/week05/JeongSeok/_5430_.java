package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _5430_ {

	static String printDeque(Deque<Integer> deque, Boolean isReverse) {
		StringBuilder sb = new StringBuilder();

		sb.append("[");
		if (deque.size() > 0) {
			if (isReverse) {
				sb.append(deque.pollLast());
				while (!deque.isEmpty()) {
					sb.append(",").append(deque.pollLast());
				}
			} else {
				sb.append(deque.pollFirst());
				while (!deque.isEmpty()) {
					sb.append(",").append(deque.pollFirst());
				}
			}
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

			boolean isReverse = false;
			boolean isChecked = false;


			// 명렁어 비교
			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'R') {
					isReverse = !isReverse;
					continue;
				}

				// 3. 뒤집힌 여부를 판단 후 D의 갯수만큼 명령어 실행
				if (isReverse) {
					if (deque.pollLast() == null) {
						System.out.println("error");
						isChecked = true;
						break;
					}
				} else {
					if (deque.pollFirst() == null) {
						System.out.println("error");
						isChecked = true;
						break;
					}
				}
			}

			if (isChecked) {
				continue;
			} else {
				System.out.println(printDeque(deque, isReverse));
			}

		}
	}

}
