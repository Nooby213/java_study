package gold;

import java.util.*;
import java.io.*;

public class Gold_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        if (n <= k) {
            System.out.println(0);
            return;
        } else {
            int min = 0;
            int[] road = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                road[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(road);
            int[] diff = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                diff[i] = road[i + 1] - road[i];
            }

            Arrays.sort(diff);
            for (int i = 0; i < n - k; i++) {
                min += diff[i];
            }
            System.out.println(min);
        }
    }
}
