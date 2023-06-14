package menz.study.week08.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	char data;
	Node left;
	Node right;

	public Node(char data) {
		this.data = data;
	}
}
public class _1991_answer {
	static int N;
	static Node[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Node[N];

		// 1. 최초 노드에 대한 정보를 입력받는다.
		for (int i = 0; i < N; i++) {
			arr[i] = new Node((char)(i + 'A'));
		}


		// 2. 1번에서 입력된 정보를 기준으로 하위 노드를 배치한다.
		for (int i = 0; i < N; i++) {
			char n, left, right;
			String s = br.readLine();
			n = s.charAt(0);
			left = s.charAt(2);
			right = s.charAt(4);
			if (left != '.') {
				arr[n - 'A'].left = arr[left - 'A'];
			}
			if (right != '.'){
				arr[n - 'A'].right = arr[right - 'A'];
			}
		}

		// 3. 전위 순회
		preOrder(arr[0]);
		sb.append("\n");
		// 4. 중위 순회
		inOrder(arr[0]);
		sb.append("\n");
		// 5. 후위 순회
		postOrder(arr[0]);
		sb.append("\n");

		System.out.println(sb);
	}

	private static void preOrder(Node node) {
		if(node == null) {
			return;
		}

		sb.append(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(Node node) {
		if(node == null) {
			return;
		}

		inOrder(node.left);
		sb.append(node.data);
		inOrder(node.right);
	}

	private static void postOrder(Node node) {
		if(node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.data);
	}
}
