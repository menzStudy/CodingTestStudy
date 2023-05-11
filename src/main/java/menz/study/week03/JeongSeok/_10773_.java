package menz.study.week03.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10773_ {

	static Stack<Integer> stack = new Stack();
	static int totalMoney = 0;

	private static void calculateMoney(int money) {
		if (money != 0) {
			stack.push(money);
			totalMoney += money;
			return;
		}

		totalMoney -= stack.pop();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		while (K-- > 0) {
			int money = Integer.parseInt(br.readLine());
			calculateMoney(money);
		}

		System.out.println(totalMoney);

	}

}
