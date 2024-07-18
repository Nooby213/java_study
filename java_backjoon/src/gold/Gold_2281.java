package gold;
import java.io.*;
import java.util.*;

public class Gold_2281 {
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
        dp = new long[n][m + 1];
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

        // 현재 줄에 이름을 추가할 수 있는 경우
        if (j + name[i] <= m) {
            if (j + name[i] == m) { // 줄을 정확히 채우는 경우
                dp[i][j] = Math.min(dp[i][j], deathNote(i + 1, 0));
            } else { // 현재 줄에 이름을 추가하는 경우
                dp[i][j] = Math.min(dp[i][j], deathNote(i + 1, j + name[i] + 1));
            }
        }

        // 다음 줄에 이름을 추가하는 경우
        if (j != 0) { // 현재 줄이 비어있지 않다면 남은 칸의 비용을 계산
            dp[i][j] = Math.min(dp[i][j], (long) Math.pow(m - j + 1, 2) + deathNote(i, 0));
        } else { // 현재 줄이 비어있다면 이름을 추가
            dp[i][j] = Math.min(dp[i][j], deathNote(i + 1, name[i] + 1));
        }

        return dp[i][j];
    }
}
