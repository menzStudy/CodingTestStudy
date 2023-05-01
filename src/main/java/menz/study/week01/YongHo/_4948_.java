package menz.study.week01.YongHo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class _4948_ {
  private static boolean[] prime = new boolean[123_456 * 2 + 1];
  static {
    Arrays.fill(prime, true);
    prime[0] = false;
    prime[1] = false;
    
    for (int i = 2; i <= 123_456 * 2; i++) {
      if (prime[i]) {
        int cnt = 2;
        for (int j = i * cnt; j <= 123_456 * 2; j = i * ++cnt) {
          prime[j] = false;
        }
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringBuilder sb = new StringBuilder();
    
    int N = Integer.parseInt(br.readLine());
    
    while(N != 0) {
      int answer = 0;
      for (int i = N + 1; i <= 2 * N; i++) {
        if (prime[i]) {
          answer += 1;
        }
      }
      
      sb.append(answer).append('\n');
      
      N = Integer.parseInt(br.readLine());
    }
    
    System.out.println(sb);
  }
}