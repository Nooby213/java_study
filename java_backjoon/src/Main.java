import javax.imageio.metadata.IIOMetadataFormatImpl;
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
        // 캐릭 수 * 힘 합
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += character[i] * str[i];
        }
        // 매일 기록
        int[][] dp = new int[d + 1][n];
        List<int[]> days = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            days.add(Arrays.copyOf(character, n));
        }
        Arrays.fill(dp[0], sum);
        // 최대값 초기화
        int max = sum;
        for (int i = 1; i <= d; i++) {
            dp[i][0] = sum;
            System.out.println("----------" + i);
            System.out.println(Arrays.toString(days.get(0)));
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j - 1] - str[j - 1] + str[j];
                dp[i][j] = train(days.get(j), j, dp[i - 1][j - 1]);
                max = Math.max(max, dp[i][j]);
//                for (int[] day : days) {
//                    System.out.println(Arrays.toString(day));
//                }
            }
        }
        System.out.println(max);

//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
    }

    static int train(int[] character, int level, int sum) {
        System.out.println(Arrays.toString(character));
        if (character[level - 1] == 0) {
            return sum;
        }
        character[level - 1]--;
        character[level]++;
        return sum + str[level] - str[level - 1];
    }
}
