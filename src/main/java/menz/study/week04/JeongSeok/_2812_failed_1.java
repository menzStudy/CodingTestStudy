package menz.study.week04.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 틀린이유
 * K가 0이 되기전에 끝나는 경우에 대한 고려하지 않음 (34번째 줄)
 */
public class _2812_failed_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String number = br.readLine();

		for (int i = 0; i < number.length(); i++) {
			while (K > 0 && !stack.isEmpty() && stack.peek() < number.charAt(i)) {
				stack.pop();
				K--;
			}
			stack.push(number.charAt(i));
		}

		// K가 0이 되기전에 끝나는 경우를 고려하지 않음 (AS-IS)
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.reverse());
	}
}
