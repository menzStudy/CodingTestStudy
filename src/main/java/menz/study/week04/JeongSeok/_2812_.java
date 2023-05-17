package menz.study.week04.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2812_ {
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
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		// LIFO 이기 떄문에 리버스 시킨다.
		String temp = sb.reverse().toString();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < temp.length() - K; i++) {
			sb2.append(temp.charAt(i));
		}

		System.out.println(sb2);

	}

}
