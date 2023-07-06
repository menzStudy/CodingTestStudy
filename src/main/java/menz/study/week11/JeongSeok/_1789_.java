package menz.study.week11.JeongSeok;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1789_ {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		long sum = 0;
		long count = 0;

		for (int i = 1; ; i++) {
			if (sum > N) {
				break;
			}

			sum += i;
			count++;
		}
		System.out.println(count - 1);
	}

}
