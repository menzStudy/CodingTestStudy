package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1927_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int X = Integer.parseInt(br.readLine());

			if (X != 0) {
				priorityQueue.add(X);
				continue;
			}

			// 0인데, 큐가 비어있지 않을 때
			if (!priorityQueue.isEmpty()) {
				sb.append(priorityQueue.poll()).append("\n");
				continue;
			}

			sb.append(0).append("\n");
		}

		System.out.println(sb);
	}

}
