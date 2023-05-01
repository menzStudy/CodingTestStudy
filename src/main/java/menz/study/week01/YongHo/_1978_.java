package menz.study.week01.YongHo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1978_ {
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    boolean[] prime = new boolean[1001];
    
    Arrays.fill(
        prime,
        true
    );
    
    prime[0] = false;
    prime[1] = false;
    
    for (int i = 2; i <= 1000; i++) {
      if (!prime[i]) {
        continue;
      }
      
      int cnt = 2;
      for (int j = i * cnt; j <= 1000; j = i * ++cnt) {
        prime[j] = false;
      }
    }
    
    int N = Integer.parseInt(br.readLine());
    
    StringTokenizer st = new StringTokenizer(
        br.readLine(),
        " "
    );
    
    int answer = 0;
    
    while (st.hasMoreTokens()) {
      if (prime[Integer.parseInt(st.nextToken())]) {
        answer++;
      }
    }
    
    System.out.println(answer);
  }
}