package Bronze;
import java.util.*;

public class Bronze_2581 {
    static int[] prime = new int[10001];
    static {
        prime[2] = 1;
        prime[3] = 1;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int min = 0;
        int cnt = 0;
        int sum = 0;
        for (int i = n; i <= m; i++) {
            isPrime(i);
            if (prime[i] == 1) {
                if (cnt == 0) {
                    min = i;
                }
                cnt++;
                sum += i;
            }
        }
        if (cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

    }

    static void isPrime(int k) {
        if (k == 1) {
            return;
        }
        if (prime[k] == 1) {
            return;
        }
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                return;
            }
        }
        prime[k] = 1;
    }
}