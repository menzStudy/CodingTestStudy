package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012_ {

	private static String checkVPS(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push('(');
			} else if (stack.isEmpty()) { // 스택이 비어있는 경우, 닫는 괄호를 입력받았으나 pop할 원소가 없을 경우
				return "NO";
			} else {
				stack.pop();
			}
		}

		return (stack.isEmpty()) ? "YES" : "NO";
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			sb.append(checkVPS(br.readLine())).append("\n");
		}

		System.out.println(sb);
	}

}
