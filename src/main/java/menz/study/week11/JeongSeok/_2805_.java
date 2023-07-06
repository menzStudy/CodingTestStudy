package menz.study.week11.JeongSeok;

import java.io.*;
import java.util.*;

public class _2805_ {
	static int N, M, result;
	static int max = Integer.MIN_VALUE;
	static int arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		// binarySearch 시작
		binarySearch(arr, M, 0, max);

		System.out.println(result);
	}

	private static void binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			long total = 0;

			int mid = (start + end) / 2;

			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					total += arr[i] - mid;
				}
			}

			if (total < target) {
				end = mid - 1;
			} else {
				result = mid;
				start = mid + 1;
			}
		}
	}
}
