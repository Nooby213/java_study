package gold;

import java.util.*;


public class Gold_1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();

        long left = 1;
        // k번째 수는 무조건 k보다 작다
        long right = k;
//        long right = (long) Math.pow(n, 2);
        long mid = (left + right) / 2;

        while (left < right) {
            mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 1; i <= n; i++) {
                long temp = mid / i;

                if (temp < 1) {
                    break;
                }
                cnt += Math.min(n, temp);
            }

            if(k <= cnt) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
