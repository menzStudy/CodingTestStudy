package menz.study.week09.YongHo;

import java.util.Arrays;

class ReverseIntegerToArray {
  public int[] solution(long n) {
    StringBuilder sb = new StringBuilder(String.valueOf(n));
    return Arrays.stream(sb.reverse().chars().map(c -> c - '0').toArray()).toArray();
    // 답안 코드
    // return new
    // StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
  }
}
