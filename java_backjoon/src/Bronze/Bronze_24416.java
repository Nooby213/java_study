package Bronze;
import java.util.*;

public class Bronze_24416 {
    static int[] f = new int[41];
    static int cnt1 = 1;
    static int cnt2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib(n);
        fibonacci(n);
        System.out.println(cnt1 + " " + cnt2);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        cnt1++;
        return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            cnt2++;
        }
        return f[n];
    }
}
