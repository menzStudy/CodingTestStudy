package menz.study.week10.KwanHo;

public class _CaesarCipher_ {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int offset = 26;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLowerCase(c)) {
                if(c + n > 'z') {
                    sb.append((char) (c + n - offset));
                } else {
                    sb.append((char) (c + n));
                }
            } else if(Character.isUpperCase(c)) {
                if(c + n > 'Z') {
                    sb.append((char) (c + n - offset));
                } else {
                    sb.append((char) (c + n));
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
