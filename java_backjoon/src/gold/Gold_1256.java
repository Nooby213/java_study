package gold;

import java.io.*;
import java.util.*;

public class Gold_1256 {
    static int[][] dict;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // a
        int m = Integer.parseInt(st.nextToken()); // z
        int k = Integer.parseInt(st.nextToken()); // k 번째
        dict = new int[n + 1][m + 1];
        dictionary(n, m);
        if (dict[n][m] < k) {
            System.out.println(-1);
            return;
        }
        find(n, m, k);
        System.out.println(sb);
    }

    static int dictionary(int a, int z) {
        if (a == 0 || z == 0) {
            dict[a][z] = 1;
            return 1;
        }
        if (dict[a][z] != 0) return dict[a][z];

        dict[a][z] = Math.min(dictionary(a - 1, z) + dictionary(a, z - 1), 1000000001);
        return dict[a][z];
    }

    static void find(int a, int z, int k) {
        if (a == 0) {
            for (int i = 0; i < z; i++) {
                sb.append('z');
            }
            return;
        }

        if (z == 0) {
            for (int i = 0; i < a; i++) {
                sb.append('a');
            }
            return;
        }

        if (k <= dict[a - 1][z]) {
            sb.append('a');
            find(a - 1, z, k);
        } else {
            sb.append('z');
            find(a, z - 1, k - dict[a - 1][z]);
        }
    }
}
