package menz.study.week01.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class _8393_ {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    
    System.out.println(IntStream.range(1,
                                       N + 1)
                                .reduce((n1, n2) -> n1 + n2)
                                .orElse(0));
  }
}