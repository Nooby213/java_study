package Silver;

import java.io.*;
import java.util.*;

public class Silver_14501 {
    static int max = 0;
    static int n;
    static int work[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        work = new int[n][2];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i + work[i][0] <= n) {
                maxCost(i + work[i][0], work[i][1]);
            }
        }

        System.out.println(max);
    }

    static void maxCost(int day, int cost) {
        max = Math.max(max, cost);
        for (int i = day; i < n; i++) {
            if (i + work[i][0] <= n) {
                maxCost(i + work[i][0], cost + work[i][1]);
            }
        }
    }
}
