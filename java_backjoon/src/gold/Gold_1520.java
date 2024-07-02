package gold;

import java.util.*;
import java.io.*;

public class Gold_1520 {
    static int m;
    static int n;
    static int[][] dp;
    static int[][] way;
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        way = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                way[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }

    static int dfs(int y, int x) {
        // 도착지라면 + 1
        if (y == m - 1 && x == n - 1) {
            return 1;
        }

        // 간 적 있으면
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        // 방문 표시
        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < m && nx >= 0 && nx < n && way[y][x] > way[ny][nx]) {
                dp[y][x] += dfs(ny, nx);
            }
        }
        // 도착 지점 도착 횟수 반환
        return dp[y][x];
    }
}
