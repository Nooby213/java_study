package gold;

import java.util.*;

public class Gold_2749 {
    static long mod = 1000000;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(fibo(n));
    }
    static long[][] power(long[][] a, long n) {
        if (n == 1) {
            return a;
        }
        if (n == 0) {
            return new long[][]{{1, 0}, {0, 1}};
        }
        if (n % 2 == 0) {
            long[][] halfPower = power(a, n / 2);
            return multiple(halfPower, halfPower);
        } else {
            return multiple(a, power(a, n - 1));
        }
    }

    static long[][] multiple(long[][] a, long[][] b) {
        long[][] res = new long[2][2];

        res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % mod;
        res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % mod;
        res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % mod;
        res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % mod;
        return res;
    }

    static long fibo(long n) {
        long[][] a = new long[][]{{1, 1}, {1, 0}};

        if (n == 0) {
            return 0;
        }

        long[][] res = power(a, n - 1);

        return res[0][0];
    }
}
