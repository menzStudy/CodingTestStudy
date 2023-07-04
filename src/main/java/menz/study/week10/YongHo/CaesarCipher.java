package menz.study.week10.YongHo;

public class CaesarCipher {
  public String solution(String s, int n) {
    StringBuilder sb = new StringBuilder();
    for (int idx = 0; idx < s.length(); idx++) {
      if ('A' <= s.charAt(idx) && s.charAt(idx) <= 'Z') {
        sb.append((char) (((s.charAt(idx) - 'A') + n) % 26 + 'A'));
      } else if ('a' <= s.charAt(idx) && s.charAt(idx) <= 'z') {
        sb.append((char) (((s.charAt(idx) - 'a') + n) % 26 + 'a'));
      } else {
        sb.append(s.charAt(idx));
      }
    }
    return sb.toString();
  }
}
