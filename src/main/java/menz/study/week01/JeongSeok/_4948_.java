package menz.study.week01.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 4948 베르트랑 공준
 */
public class _4948_ {

	static int[] prime = new int[1000001];

	public static void makePrimeNumberArr() {
		//소수가 아니라면 0, 0과 1은 소수가 아니므로 0
		prime[0] = prime[1] = 0;

		for(int i = 2; i <= 1000000; i++) prime[i] = i; //2부터 소수를 구하고자 하는 구간의 모든 수 나열

		for(int i = 2; i < 1000000;i++){
			if(prime[i] == 0) continue; //소수가 아니라면 continue
			for(int j = 2*i; j <= 1000000; j+=i) prime[j] = 0; //소수의 배수는 소수를 약수로 가지므로 제외
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		makePrimeNumberArr();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;

			if (n == 0) {
				break;
			}

			for (int i = n + 1; i <= 2 * n; i++) {
				if (prime[i] != 0) {
					answer++;
				}
			}

			System.out.println(answer);
		}
	}
}