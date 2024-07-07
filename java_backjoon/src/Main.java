import java.util.*;
import java.io.*;

public class Main {
    static int[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 레벨 n, n당 캐릭터 수
        int n = Integer.parseInt(br.readLine());
        int[] character = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            character[i] = Integer.parseInt(st.nextToken());
        }
        // 힘
        str = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            str[i] = Integer.parseInt(st.nextToken());
        }
        // 날짜
        int d = Integer.parseInt(br.readLine());

        // dp 배열 초기화
        int[][][] dp = new int[d + 1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[0][i][j] = character[j]; // dp[0][i][j]를 character 배열로 초기화
            }
        }

        // 초기화된 dp 배열 출력 (디버깅 용)
        for (int day = 0; day <= d; day++) {
            System.out.println("Day " + day + ":");
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(dp[day][i]));
            }
        }
    }
}
