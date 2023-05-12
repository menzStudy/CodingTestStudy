package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * 틀린 이유
 * LinkedList 사용시 시간초과 확률이 매우 높음
 */

public class _1406_time {

	static int M, index;
	static LinkedList<Character> list = new LinkedList<Character>();

	private static void executeCommand(String command) {
		char c = command.charAt(0);

		switch(c) {
			case 'L':
				if(index != 0) {
					index = index - 1;
				}

				break;
			case 'D':
				if (index != list.size()) {
					index = index + 1;
				}
				break;
			case 'B':
				if(index != 0) {
					list.remove(index-1);
					index--;
				}
				break;
			case 'P':
				char t = command.charAt(2);
				list.add(index, t);
				index++;

				break;
			default:
				break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String text = br.readLine();
		M = Integer.parseInt(br.readLine());

		for(int i = 0; i < text.length(); i++) {
			list.add(text.charAt(i));
		}

		// 처음 시작시 커서는 문장의 맨 뒤에서 시작해야함
		index = list.size();

		for(int i = 0; i < M; i++) {
			executeCommand(br.readLine());
		}

		for (Character character : list) {
			bw.write(character);
		}
	}

}
