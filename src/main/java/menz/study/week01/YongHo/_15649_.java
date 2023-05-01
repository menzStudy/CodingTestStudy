package menz.study.week01.YongHo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15649_ {
  private static StringBuilder sb = new StringBuilder();
  
  public static void main (String[] args) throws Exception {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // Your code
    StringTokenizer st = new StringTokenizer(
        br.readLine(),
        " "
    );
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    int[] arr = new int[N];
    
    for (int i = 0; i < N; i++) {
      arr[i] = i + 1;
    }
    
    boolean[] visited = new boolean[N];
    int[] selection = new int[M];
    
    permutation(
        arr,
        0,
        M,
        visited,
        selection
    );
    
    System.out.println(sb);
    br.close();
  }
  
  public static void permutation (
      int[] arr,
      int selectedCnt,
      int totalCnt,
      boolean[] visited,
      int[] selection
  ) {
    if (selectedCnt == totalCnt) {
      sb.append(Arrays.toString(selection)
                      .replaceAll(
                          "[\\[\\]\\,]",
                          ""
                      ))
        .append('\n');
      return;
    }
    
    for (int i = 0; i < arr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        selection[selectedCnt] = arr[i];
        permutation(
            arr,
            selectedCnt + 1,
            totalCnt,
            visited,
            selection
        );
        visited[i] = false;
      }
    }
    
  }
  
}