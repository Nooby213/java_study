package Silver;

import java.util.*;

public class Silver_1740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        // n을 2진수 문자열로 변환하고 뒤집음
        String binary = new StringBuilder(Long.toBinaryString(n)).reverse().toString();

        long now = 1;
        long sum = 0;

        for (char b : binary.toCharArray()) {
            if (b == '1') {
                sum += now;
            }
            now *= 3;
        }

        System.out.println(sum);
    }
}