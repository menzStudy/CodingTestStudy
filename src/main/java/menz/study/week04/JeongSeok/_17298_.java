package menz.study.week04.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class _17298_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		Stack<Character> stack = new Stack<>();

		int result = 0;

		for (int i = 0; i < input.length(); i++) {
			// 열린 괄호면 스택에 추가.
			if (input.charAt(i) == '(') {
				stack.push('(');
				continue;
			}

			// 닫힌 괄호일 경우
			if (input.charAt(i) == ')') {
				// 일단 stack에서 pop을 실행
				stack.pop();

				// 그 전 괄호가 열린 괄호면 레이저를 의미
				if (input.charAt(i - 1) == '(') {
					// 현재 stack의 사이즈만큼 더함
					result += stack.size();
				} else {
					// 그 전 괄호가 닫힌 괄호면 레이저가 아님.
					// 단순히 막대기 하나 추가함
					result++;
				}
			}
		}

		System.out.println(result);
	}

}
