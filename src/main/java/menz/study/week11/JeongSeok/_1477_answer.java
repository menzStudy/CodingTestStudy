package menz.study.week11.JeongSeok;

import java.util.*;
import java.io.*;
public class _1477_answer {

	static int N, M, L, result;
	static int arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N + 2];

		arr[0] = 0;
		arr[N + 1] = L;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		binarySearch(arr, M, 1, L - 1);

		System.out.println(result);

	}

	private static void binarySearch(int[] arr, int target, int start, int end) {

		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;

			for (int i = 1; i < arr.length; i++) {
				sum += (arr[i] - arr[i-1] - 1) / mid;
			}

			if (sum > target) {
				start = mid + 1;
			} else {
				result = mid;
				end = mid - 1;
			}
		}
	}
}
