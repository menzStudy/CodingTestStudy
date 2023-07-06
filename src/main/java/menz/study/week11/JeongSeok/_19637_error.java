package menz.study.week11.JeongSeok;

import java.io.*;
import java.util.*;
public class _19637_error {

	static int N, M;

	// 전투력 등급표
	static String powerSystem[][];
	// 캐릭터별 전투력을 담을 배열
	static int power[];
	static String result[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		powerSystem = new String[N][2];
		power = new int[M];
		result = new String[M];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < split.length; j++) {
				powerSystem[i][j] = split[j];
			}
		}

		for (int i = 0; i < M; i++) {
			power[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(power);

		setPower();
		printPower();
	}

	private static void setPower() {
		for (int i = 0; i < M; i++) {
			if (power[i] <= Integer.parseInt(powerSystem[0][1])) {
				result[i] = powerSystem[0][0];
			} else if (power[i] <= Integer.parseInt(powerSystem[1][1])) {
				result[i] = powerSystem[1][0];
			} else if (power[i] <= Integer.parseInt(powerSystem[2][1])) {
				result[i] = powerSystem[2][0];
			}
		}
	}

	private static void printPower() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
}
