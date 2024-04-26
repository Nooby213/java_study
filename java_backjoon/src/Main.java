import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] balance;
    static boolean[] used;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        balance = new int[n][n];
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                balance[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeTeam(0, 0);
        System.out.println(min);
    }

    static void makeTeam(int num, int cnt) {
        if (cnt == n / 2) {
            int tempSum1 = 0;
            int tempSum2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (used[i] && used[j]) {
                        tempSum1 += balance[i][j];
                    } else if (!used[i] && !used[j]) {
                        tempSum2 += balance[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(tempSum1 - tempSum2));
            if (min == 0) {
                System.out.println(min);
                System.exit(0);
            }
            return;
        }

        if (num == n) {
            return;
        }

        for (int i = num; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                makeTeam(num + 1, cnt + 1);
                used[i] = false;
            }
        }
    }
}