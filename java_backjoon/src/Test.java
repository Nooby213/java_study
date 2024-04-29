import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = numbers[1];
        if (n > 1) {
            dp[2] = numbers[1] + numbers[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + numbers[i], dp[i - 3] + numbers[i - 1] + numbers[i]);
        }
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxCnt = Math.max(maxCnt, dp[i]);
        }
        System.out.println(maxCnt);
        System.out.println(Arrays.toString(dp));
    }
}
