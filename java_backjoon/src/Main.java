import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] balance;
    static int total;
    static boolean[] member;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        member = new boolean[n];
        balance = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                balance[i][j] = Integer.parseInt(st.nextToken());
                total += balance[i][j];
            }
        }
        makeTeam(0, 0, new LinkedList<>());
    }
    static void makeTeam(int num, int cnt, List<Integer> list) {
        if (cnt == n / 2) {
//            min = Math.min(min, Math.abs(total - (2 * temp)));
            return;
        }
        makeTeam(num + 1, cnt + 1, new LinkedList<>(list).add(num));
    }
}