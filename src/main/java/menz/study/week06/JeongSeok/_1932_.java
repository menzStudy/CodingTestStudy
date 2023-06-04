package menz.study.week06.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932_ {

	static int[][] intTriangle, dpTriangle;
	static int N;

	public static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());

		intTriangle = new int[N][N];
		dpTriangle = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				intTriangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void startDP() {
		dpTriangle[0][0] = intTriangle[0][0];

		for (int i = 1; i < N; i++) {
			// 맨 왼쪽 값, 맨 오른쪽 값 셋팅
			dpTriangle[i][0] = dpTriangle[i - 1][0] + intTriangle[i][0];
			dpTriangle[i][i] = dpTriangle[i - 1][i - 1] + intTriangle[i][i];

			// 그 외 이전 단계의 좌, 우 값 중 제일 큰 값을 골라야만 최대값을 유지할 수 있음
			for (int j = 1; j <= i; j++) {
				dpTriangle[i][j] = Math.max(dpTriangle[i - 1][j], dpTriangle[i - 1][j - 1]) + intTriangle[i][j];
			}

		}
	}

	public static void printMaxValue() {
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(dpTriangle[N - 1][i], max);
		}

		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		init(new BufferedReader(new InputStreamReader(System.in)));
		startDP();
		printMaxValue();
	}

}
