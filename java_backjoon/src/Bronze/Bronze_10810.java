package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bronze_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        // N 개의 바구니, 1 ≤ N ≤ 100
        int N = Integer.parseInt(st1.nextToken());
        // M 번 던짐, 1 ≤ M ≤ 100
        int M = Integer.parseInt(st1.nextToken());
        int[] baskets = new int[N];
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int K = Integer.parseInt(st2.nextToken());
            for (int j = start - 1; j < end; j++) {
                baskets[j] = K;
            }
        }
        for (int i = 0; i < N; i++) {
            if (i < N - 1) {
                System.out.print(baskets[i] + " ");
            } else {
                System.out.println(baskets[i]);
            }
        }
    }
}
