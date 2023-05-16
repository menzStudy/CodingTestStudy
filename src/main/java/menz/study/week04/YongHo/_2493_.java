package menz.study.week04.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2493_ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] height = new int[N + 1];
    int[] receive = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    height[1] = Integer.parseInt(st.nextToken());

    for (int idx = 2; idx <= N; idx++) {
      height[idx] = Integer.parseInt(st.nextToken());

      int receiveIdx = idx - 1;
      while (receiveIdx >= 1) {
        if (height[receiveIdx] >= height[idx]) {
          receive[idx] = receiveIdx;
          break;
        }
        receiveIdx = receive[receiveIdx];
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int idx = 1; idx <= N; idx++) {
      sb.append(receive[idx]).append(" ");
    }

    System.out.println(sb);
  }
}
