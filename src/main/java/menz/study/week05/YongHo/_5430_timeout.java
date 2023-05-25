package menz.study.week05.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5430_timeout {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    loop:
    while (T-- > 0) {
      String p = br.readLine();
      int N = Integer.parseInt(br.readLine());
      String arrStr = br.readLine();
      String[] numStr = arrStr.substring(1, arrStr.length() - 1).split(",");
      int[] nums = new int[N];
      int size = N;

      for (int i = 0; i < N; i++) {
        nums[i] = Integer.parseInt(numStr[i]);
      }

      for (int i = 0; i < p.length(); i++) {
        char command = p.charAt(i);

        if (command == 'R') {
          if (i + 1 != p.length() && p.charAt(i+1) == 'R') {
            i= i + 1;
            continue;
          }
          for (int idx = 0; idx < size / 2; idx++) {
            int temp = nums[size - 1 - idx];
            nums[size - 1 - idx] = nums[idx];
            nums[idx] = temp;
          }
        } else {
          if (size == 0) {
            sb.append("error\n");
            continue loop;
          } else {
            System.arraycopy(nums, 1, nums, 0, --size);
          }
        }
      }

      sb.append("[");
      for (int i = 0; i < size; i++) {
        sb.append(nums[i]).append(",");
      }
      sb.deleteCharAt(sb.length()-1);
      sb.append("]\n");
    }

    System.out.println(sb);
    br.close();
  }
}
