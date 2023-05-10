package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Stack {

	private ArrayList<Integer> stack = new ArrayList<>();

	public void push(int x) {
		stack.add(x);
	}

	public int pop() {
		if (stack.size() != 0) {
			int value = stack.get(size() - 1);
			stack.remove(size() - 1);

			return value;
		}

		return -1;
	}

	public int size() {
		return stack.size();
	}

	public int empty() {
		return (stack.size() == 0) ? 1 : 0;
	}

	public int top() {
		return (stack.size() != 0) ? stack.get(size() - 1) : -1;
	}
}

public class _10828_ {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack stack = new Stack();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					sb.append(stack.pop()).append("\n");
					break;
				case "size":
					sb.append(stack.size()).append("\n");
					break;
				case "empty":
					sb.append(stack.empty()).append("\n");
					break;
				case "top":
					sb.append(stack.top()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}
