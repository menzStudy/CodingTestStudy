package menz.study.week10.JeongSeok;

public class StrangeCipherGenerator {
  public String solution(String s) {
    s = s.toUpperCase();
    StringBuilder sb = new StringBuilder();

    int idx = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        if (idx % 2 == 1) {
          sb.append((char) (s.charAt(i) + 32));
          idx++;
        } else {
          sb.append(s.charAt(i));
          idx++;
        }
      } else {
        idx = 0;
        sb.append(" ");
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {}
}
