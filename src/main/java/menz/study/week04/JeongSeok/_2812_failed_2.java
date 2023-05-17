package menz.study.week04.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 틀린이유
 * 반례 존재
 * 5 1
 * 54321
 * 5432 --> output
 */

public class _2812_failed_2 {
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

		// K만큼 삭제하기 전에 위에 과정이 끝나는 경우
		// N = 5, K = 2, input = 55555
		while (stack.size() > K) {
			sb.append(stack.pop());
		}

		System.out.println(sb.reverse());
	}
}
