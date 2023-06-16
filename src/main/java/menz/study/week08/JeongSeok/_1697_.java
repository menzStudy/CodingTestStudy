package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int subin = Integer.parseInt(st.nextToken());
		int sister = Integer.parseInt(st.nextToken());

		int[] distance = new int[100_001];
		boolean[] visited = new boolean[100_001];
		Queue<Integer> queue = new LinkedList<>();

		queue.add(subin);
		distance[subin] = 0;
		visited[subin] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == sister) {
				System.out.println(distance[cur]);
				return;
			}

			int x1 = cur + 1;
			int x2 = cur - 1;
			int x3 = cur * 2;

			if (x1 >= 0 && x1 <= 100000 && !visited[x1]) {
				queue.add(x1);
				distance[x1] = distance[cur] + 1;
				visited[x1] = true;
			}

			if (x2 >= 0 && x2 <= 100000 && !visited[x2]) {
				queue.add(x2);
				distance[x2] = distance[cur] + 1;
				visited[x2] = true;
			}

			if (x3 >= 0 && x3 <= 100000 && !visited[x3]) {
				queue.add(x3);
				distance[x3] = distance[cur] + 1;
				visited[x3] = true;
			}
		}
	}

}
