import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class _1929_ {
  private static boolean[] prime = new boolean[1_000_001];
  
  public static void main(String[] args) throws Exception {
    Arrays.fill(prime, true);
    prime[0] = false;
    prime[1] = false;
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    final int M = Integer.parseInt(st.nextToken());
    final int N = Integer.parseInt(st.nextToken());
    
    for (int i = 2; i <= N; i++) {
      if (prime[i]) {
        int cnt = 2;
        for (int j = i * cnt; j <= N; j = i * ++cnt) {
          prime[j] = false;
        }
      }
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = M; i<= N; i++) {
      if(prime[i]) {
        sb.append(i).append('\n');
      }
    }
    
    System.out.println(sb);
    br.close();
  }
}