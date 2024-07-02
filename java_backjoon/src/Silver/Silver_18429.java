package Silver;

import java.io.*;
import java.util.*;


public class Silver_18429 {
    static int cnt = 0;
    static int[] used;
    static int n;
    static int k;
    static int[] weight;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        used = new int[n];
        weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        workout(0, 500);
        System.out.println(cnt);
    }

    static void workout(int day, int tempWeight) {
        if (tempWeight < 500) {
            return;
        }

        if (day == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i] != 1) {
                used[i] = 1;
                workout(day + 1, tempWeight + weight[i] - k);
                used[i] = 0;
            }
        }
    }
}

