package menz.study.week04.JeongSeok;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CustomQueue2 {
	static int[] queue = new int[10_000];

	static int size = 0;
	static int front = 0;
	static int back = 0;

	public void push(int X) {
		queue[back] = X;
		back++;
		size++;
	}

	public int pop() {

		int value;

		if (size == 0) {
			return -1;
		} else {
			value = queue[front];
			size--;
			front++;
		}

		return value;
	}

	public int size() {
		return size;
	}

	public int empty() {
		return (size == 0) ? 1 : 0;
	}

	public int front() {
		return (size == 0) ? -1 : queue[front];
	}

	public int back() {
		return (size == 0) ? -1 : queue[back - 1];
	}
}
public class _10845_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		CustomQueue2 customQueue = new CustomQueue2();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
				case "push":
					customQueue.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					sb.append(customQueue.pop()).append("\n");
					break;
				case "size":
					sb.append(customQueue.size()).append("\n");
					break;
				case "empty":
					sb.append(customQueue.empty()).append("\n");
					break;
				case "front":
					sb.append(customQueue.front()).append("\n");
					break;
				case "back":
					sb.append(customQueue.back()).append("\n");
					break;
			}
		}

		System.out.println(sb);
	}

}
