package menz.study.week11.JeongSeok;

import java.io.*;
import java.util.*;

public class _2512_ {

	static int N, M, result;
	static int arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		int total = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}

		Arrays.sort(arr);

		M = Integer.parseInt(br.readLine());

		// 1. 모든 요청이 배정될 수 있는 경우
		if (total <= M) {
			System.out.println(arr[N - 1]);
		} else {
			// 모든 요청이 배정될 수 없는 경우
			binarySearch(arr, M, 0, arr[N - 1]);
			System.out.println(result);
		}
	}

	private static void binarySearch(int[] arr, int target, int start, int end) {

		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;

			for (int i = 0; i < arr.length; i++) {
				// 상한액보다 큰 금액은 상한액으로 간다.
				if (arr[i] >= mid) {
					sum += mid;
				} else {
					sum += arr[i];
				}
			}

			if (sum <= target) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
	}
}
