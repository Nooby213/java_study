package Silver;
import java.util.*;
import java.io.*;

public class Silver_1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] houses = new int[n][3];
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        // 첫 집 비용
        for (int i = 0; i < 3; i++) {
            dp[0][i] = houses[0][i];
        }
        // 다음 집에서 이전의 집과 다른 집을 고를때 최소비용 저장
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + houses[i][j]);
                    }
                }
            }
        }
        int min = dp[n-1][0];
        for (int i = 1; i < 3; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        System.out.println(min);
    }
}
