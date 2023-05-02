package menz.study.week02.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9020_ {
	static int MAX_ARRAY_SIZE = 10000;
	static int[] primeNumbers = new int[MAX_ARRAY_SIZE + 1];
	static StringBuilder sb = new StringBuilder();


	public static void makePrimeNumberArray() {

		// 에라토스테네스의 체 초기화
		for (int i = 2; i <= MAX_ARRAY_SIZE; i++) {
			primeNumbers[i] = i;
		}

		for (int i = 2; i <= MAX_ARRAY_SIZE; i++) {
			if (primeNumbers[i] == 0) {
				continue;
			}

			for (int j = i * i; j <= MAX_ARRAY_SIZE; j += i) {
				primeNumbers[j] = 0;
			}
		}
	}

	public static void findGoldBach(int number) {
		// 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.
		// 예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다.

		// (방법 1) 입력받은 number로 부터 number보다 작고, 제일 가까운 소수를 찾는다.
		// 두 수를 뺸다.
		// 남은 수도 마찬가지로 제일 가까운 소수를 찾고 0이 되는지 확인한다.
		// 하지만 10인 경우에 3 + 7, 5 + 5 이 두가지 중 하나를 선택해야하고, 그 기준이 명확하지 않음


		// (방법 2) 입력받은 number를 2로 나눈 후 몫이 만약 소수가 아니면 몫을 기준으로 좌 우에 있는 소수를 가져온다.
		// 몫이 만약 소수 인 경우 해당 수를 출력한다. (가장 적절함)


		// (방벙 3) 2중 for문을 이용하여 number가 계산되는 수들을 구한 후
		// 절대값으로 두 수의 차이를 구한다.
		// 만약 더 작다면 그 수를 출력 -- (시간초과)

		int left = number / 2;
		int right = number / 2;

		while (true) {
			if (primeNumbers[left] != 0 && primeNumbers[right] != 0) {
				sb.append(left).append(" ").append(right).append("\n");
				break;
			}
			left--;
			right++;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		long start = System.currentTimeMillis();

		makePrimeNumberArray();

		for (int i = 0; i < testCase; i++) {
			findGoldBach(Integer.parseInt(br.readLine()));
		}

		long end = System.currentTimeMillis();

		System.out.println("수행시간: " + (end - start) + " ms");

		System.out.println(sb.toString());

	}

}
