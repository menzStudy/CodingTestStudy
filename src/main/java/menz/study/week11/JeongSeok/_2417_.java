package menz.study.week11.JeongSeok;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2417_ {

	static long N, result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());

		binarySearch(N, 0, N);
	}

	private static void binarySearch(long target, long start, long end) {
		while (start <= end) {
			long mid = (start + end) / 2;

			if (Math.pow(mid, 2) >= target) {
				end = mid - 1;
				result = mid;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(result);
	}

}
