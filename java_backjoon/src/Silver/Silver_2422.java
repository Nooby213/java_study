package Silver;
import java.io.*;
import java.util.*;

public class Silver_2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        boolean[][] combinations = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            combinations[a - 1][b - 1] = true;
            combinations[b - 1][a - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (combinations[i][j] || combinations[j][k] || combinations[k][i]) {
                        continue;
                    } else {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
