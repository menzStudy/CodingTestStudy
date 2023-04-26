import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1978_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            int cnt = primeCheck(n, n * 2);

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);

    }

    private static int primeCheck(int n, int m) {
        int cnt = 0;
        for (int i = n + 1; i <= m; i++) {
            boolean isPrime = true;
            if(i == 1) continue;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) cnt++;
        }

        return cnt;
    }
}
