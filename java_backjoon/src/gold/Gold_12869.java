package gold;

import java.io.*;
import java.util.*;

public class Gold_12869 {
    static int[][] atkWay = new int[][]
            {{9, 3, 1},
                    {9, 1, 3},
                    {3, 9, 1},
                    {3, 1, 9},
                    {1, 3, 9},
                    {1, 9, 3}};
    static int min = Integer.MAX_VALUE;
    static int[] scvs = new int[3];
    static int[][][] atk = new int[61][61][61];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            scvs[i] = Integer.parseInt(st.nextToken());
        }

        attack(0, scvs[0], scvs[1], scvs[2]);

        System.out.println(min);
    }

    static void attack(int cnt, int s1, int s2, int s3) {
        s1 = Math.max(s1, 0);
        s2 = Math.max(s2, 0);
        s3 = Math.max(s3, 0);

        if (min <= cnt) return;

        if (atk[s1][s2][s3] != 0 && atk[s1][s2][s3] <= cnt) return;

        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = cnt;
            return;
        }

        atk[s1][s2][s3] = cnt;

        for (int[] way : atkWay) {
            int ns1 = s1 - way[0];
            int ns2 = s2 - way[1];
            int ns3 = s3 - way[2];
            attack(cnt + 1, ns1, ns2, ns3);
        }
    }
}
