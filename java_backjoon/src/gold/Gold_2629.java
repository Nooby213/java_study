package gold;

import java.io.*;
import java.util.*;

public class Gold_2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = n * 500;
        boolean[][] dp = new boolean[n + 1][max + 1];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            int w = weight[i - 1];
            for (int j = 0; j <= max; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    dp[i][j + w] = true;
                    dp[i][Math.abs(j - w)] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int choo = Integer.parseInt(st.nextToken());
            if (choo > max) {
                sb.append("N ");
            } else if (dp[n][choo]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }
}
