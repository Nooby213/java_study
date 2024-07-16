import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static long[][] dp;
    static int[] name;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        name = new int[n];
        dp = new long[n][m];
        for (int i = 0; i < n; i++) {
            name[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(deathNote(0, 0));
    }

    static long deathNote(int i, int j) {
        // 사람 이름 다쓰면 뒤에 칸 안 씀
        if (i == n) {
            return 0;
        }

        // 온 적 있으면
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        // 지금 줄에 추가
        if (j + name[i] < m) {
            dp[i][j] = Math.min(dp[i][j], deathNote(i + 1, j + name[i]));
        }

        // 다음 줄에 추가
        dp[i][j] = (long) Math.min(dp[i][j], Math.pow(m - j + 1, 2) + deathNote(i, 0));


        return dp[i][j];
    }
}
