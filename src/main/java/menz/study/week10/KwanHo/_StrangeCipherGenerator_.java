package menz.study.week10.KwanHo;

public class _StrangeCipherGenerator_ {
    public String solution(String s) {
        String answer = "";

        boolean isLowerCase = false;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!isLowerCase && Character.isAlphabetic(ch)) {
                answer += Character.toUpperCase(ch);
                isLowerCase = true;
            } else if(isLowerCase && Character.isAlphabetic(ch)) {
                answer += Character.toLowerCase(ch);
                isLowerCase = false;
            } else {
                answer += ' ';
                isLowerCase = false;
            }
        }

        return answer;
    }
}
