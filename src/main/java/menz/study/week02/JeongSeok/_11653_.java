package menz.study.week02.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11653_ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int i = 2;

		while (N != 1) {
			if (N % i == 0) {
				N = N / i;
				sb.append(i).append("\n");
			} else {
				i++;
			}
		}
		System.out.println(sb.toString());
	}
}
