package menz.study.week09.KwanHo;

public class _ReverseIntegerToArray_ {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        StringBuilder sb = new StringBuilder(num);

        sb = sb.reverse();

        String[] stringArr = sb.toString().split("");

        int[] answer = new int[sb.length()];

        for (int i = 0; i < sb.length(); i++) {
            answer[i] = Integer.parseInt(stringArr[i]);
        }

        return answer;
    }
}
