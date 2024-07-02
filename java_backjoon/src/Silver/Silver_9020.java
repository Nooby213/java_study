package Silver;

import java.io.*;

public class Silver_9020 {
    static boolean[] prime = new boolean[10001];

    static {

        prime[2] = true;
        prime[3] = true;

        for (int j = 4; j <= 10000; j++) {
            isPrime(j);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = n / 2; j >= 2; j--) {
                int a = n - j;
                if (prime[a] && prime[j]) {
                    sb.append(j).append(" ").append(a).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static void isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return;
            }
        }
        prime[num] = true;
    }
}
