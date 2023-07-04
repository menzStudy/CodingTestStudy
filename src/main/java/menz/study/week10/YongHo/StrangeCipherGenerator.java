package menz.study.week10.YongHo;

class StrangeCipherGenerator {
  public String solution(String s) {
    StringBuilder sb = new StringBuilder();
    int wIdx = 0;
    int idx = 0;
    int step = 'a' - 'A';
    while (idx < s.length()) {
      if ('a' <= s.charAt(idx) && s.charAt(idx) <= 'z') {
        if (wIdx % 2 == 0) sb.append((char) (s.charAt(idx) - step));
        else sb.append(s.charAt(idx));

        wIdx++;
      } else if ('A' <= s.charAt(idx) && s.charAt(idx) <= 'Z') {
        if (wIdx % 2 == 0) sb.append(s.charAt(idx));
        else sb.append((char) (s.charAt(idx) + step));

        wIdx++;
      } else if (s.charAt(idx) == ' ') {
        sb.append(" ");
        wIdx = 0;
      }
      idx++;
    }

    return sb.toString();
  }
}
