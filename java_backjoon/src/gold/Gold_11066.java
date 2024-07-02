package gold;

import java.io.*;
import java.util.*;


public class Gold_11066 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] cost = new int[n];
            int[][] dp = new int[n + 1][n + 1];
            int[] sum = new int[n + 1];

            for (int j = 0; j < n; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
                // 구간 합
                sum[j + 1] = sum[j] + cost[j];
            }

            // 두 부분의 합의 최소값 구하기
            // 소설 2개의 합부터 n개의 합까지 순차적으로 계산
            for (int range = 1; range <= n; range++) {
                for (int start = 1; start <= n - range; start++) {
                    int end = start + range;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start-1]);
                    }
                }
            }

            System.out.println(dp[1][n]);
        }
    }
}
