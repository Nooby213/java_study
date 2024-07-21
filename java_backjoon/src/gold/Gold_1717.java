package gold;

import java.util.*;
import java.io.*;

public class Gold_1717 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (act == 0) {
                union(a, b);
            } else {
                sb.append((find(a) == find(b)) ? "YES" : "NO").append('\n');
            }
        }
        System.out.println(sb);
    }
    static void union(int a, int b) {
        int aIn = find(a);
        int bIn = find(b);
        if (aIn != bIn) {
            arr[bIn] = aIn;
        }
    }

    static int find(int x) {
        if (arr[x] != x) {
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }
}