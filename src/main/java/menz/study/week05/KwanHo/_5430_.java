package menz.study.week05.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5430_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Deque<Integer> dq = new ArrayDeque<>();
            boolean flag = true;
            boolean error = false;

            String command = br.readLine();
            Integer.parseInt(br.readLine()); // 생략
            String numArr = br.readLine();

            numArr = numArr.substring(1, numArr.length() - 1);
            String[] arr = numArr.split(",");

            if (numArr != "") {
                for (int j = 0; j < arr.length; j++) {
                    dq.add(Integer.parseInt(arr[j]));
                }
            }

            for (int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);
                if (c == 'R') {
                    flag = !flag;
                } else {
                    if (!dq.isEmpty()) {
                        if (flag) {
                            dq.pollFirst();
                        } else {
                            dq.pollLast();
                        }
                    } else {
                        error = true;
                    }
                }

                if (error)
                    break;
            }

            if (error) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                if (flag) {
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollFirst());
                        if (dq.isEmpty())
                            break;
                        sb.append(",");
                    }
                } else {
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                        if (dq.isEmpty())
                            break;
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}