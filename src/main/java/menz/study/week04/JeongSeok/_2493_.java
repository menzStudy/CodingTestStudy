package menz.study.week04.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
	int num;
	int height;

	public Top(int num, int height) {
		this.num = num;
		this.height = height;
	}
}

public class _2493_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Top> stack = new Stack<>();

		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new Top(i, height));
			} else {
				while (true) {
					if (stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new Top(i, height));
						break;
					}

					Top top = stack.peek();

					if (top.height > height) {
						sb.append(top.num).append(" ");
						stack.push(new Top(i, height));
						break;
					} else {
						stack.pop();
					}
				}
			}
		}

		System.out.println(sb);
	}

}
