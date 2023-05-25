package menz.study.week05.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11727_ {

	static int MAX_LENGTH = 1000;
	static int[] dp = new int[MAX_LENGTH + 1];

	// 찍었는데 맞았네,,,
	// n이 3개인 경우는
	// n - 1 일 땐 경우의 수가 달라지지 않음 그냥 블럭하나만 더 붙힐 뿐,,
	// n - 2 일 땐 블럭 하나 더 붙혔는데 갑자기 2배로 늘어남 그래서 점화식을 찍어서 성립시켜봄,,
	public static void initArray() {
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= MAX_LENGTH ; i++) {
			dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
		}
	}

	public static void main(String[] args) throws IOException {
		initArray();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(dp[Integer.parseInt(br.readLine())]);

	}

}
