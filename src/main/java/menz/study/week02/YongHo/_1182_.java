package menz.study.week02.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답안 참고 풀이
public class _1182_ {

  static int N, S, answer;
  static int[] array;

  private static void rec_func(int k, int value) {
    if (k == N + 1) {
      if (value == S) {
        answer++;
      }
    } else {
      // K번째 원소를 포함시킬지 결정하고 재귀호출
      // 포함시킬 경우
      // K번째 원소까지 다 더한 수
      rec_func(k + 1, value + array[k]);

      // 포함시키지 않을 경우
      // K - 1번째 원소까지 다 더한 수
      rec_func(k + 1, value);
    }
  }

  public static void main(String[] args) throws IOException {
    input();

    rec_func(1, 0);
    if (S == 0) {
      answer--;
    }
    System.out.println(answer);
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    answer = 0;

    array = new int[N + 1];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }
  }
}
