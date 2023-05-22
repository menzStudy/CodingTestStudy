package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Document {
	int idx;
	int priority;

	public Document(int idx, int priority) {
		this.idx = idx;
		this.priority = priority;
	}
}

/**
 * 구현 아이디어 부족으로 답지 참고 하악,,,
 */
public class _1966_answer {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			LinkedList<Document> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				queue.offer(new Document(i, Integer.parseInt(st.nextToken())));
			}

			int count = 0;

			while (!queue.isEmpty()) {	// 한 케이스에 대한 반복문

				Document front = queue.poll();	// 가장 첫 원소
				boolean isMax = true;	// front 원소가 가장 큰 원소인지를 판단하는 변수

				// 큐에 남아있는 원소들과 중요도를 비교
				for(int i = 0; i < queue.size(); i++) {

					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
					if(front.priority < queue.get(i).priority) {
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
						queue.offer(front);
						// front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
						isMax = false;
						break;
					}
				}

				// front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
				if(isMax == false) {
					continue;
				}

				// front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
				count++;
				if(front.idx == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
					break;
				}

			}

			sb.append(count).append('\n');

		}
		System.out.println(sb);
	}

}
