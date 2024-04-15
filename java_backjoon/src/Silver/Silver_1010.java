package Silver;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Silver_1010 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, m;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            BigInteger numerator = factorial(m);
            BigInteger denominator1 = factorial(m - n);
            BigInteger denominator2 = factorial(n);
            BigInteger result = numerator.divide(denominator1.multiply(denominator2));
            System.out.println(result);
        }
    }

    static BigInteger factorial(int i) {
        BigInteger result = BigInteger.ONE;
        for (int j = 1; j <= i; j++) {
            result = result.multiply(BigInteger.valueOf(j));
        }
        return result;
    }
}
