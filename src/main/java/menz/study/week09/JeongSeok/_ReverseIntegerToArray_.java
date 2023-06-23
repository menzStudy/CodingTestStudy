package menz.study.week09.JeongSeok;

public class _ReverseIntegerToArray_ {

	public int[] solution(long n) {
		String reverse = new StringBuilder(String.valueOf(n)).reverse().toString();
		int[] answer = new int[reverse.length()];

		String[] split = reverse.split("");

		for (int i = 0; i < split.length; i++) {
			answer[i] = Integer.parseInt(split[i]);
		}

		return answer;
	}

	public static void main(String[] args) {

	}

}
