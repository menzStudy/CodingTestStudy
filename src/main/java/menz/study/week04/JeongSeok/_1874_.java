package menz.study.week04.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		int start = 0;

		while (N-- > 0) {
			int end = Integer.parseInt(br.readLine());

			if (end > start) {
				for (int i = start + 1; i <= end; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				start = end;
			} else if (stack.peek() != end) {
				System.out.println("NO");
				return;
			}

			stack.pop();
			sb.append("-").append("\n");
		}

		System.out.println(sb);
	}

}
