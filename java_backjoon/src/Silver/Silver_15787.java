package Silver;

import java.io.*;
import java.util.*;

public class Silver_15787 {
    static int[] trains;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        trains = new int[n + 1];

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            // & = 둘 다 1일때만 1
            // | = 둘 중 하나 1이면 1
            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                trains[i] |= (1 << (x - 1));
            } else if (command == 2) {
                int x = Integer.parseInt(st.nextToken());
                trains[i] &= ~(1 << (x - 1));
            } else if (command == 3) {
                trains[i] = (trains[i] << 1) & ((1 << 20) - 1);
            } else if (command == 4) {
                trains[i] >>= 1;
            }
        }

        Set<Integer> trainSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            trainSet.add(trains[i]);
        }

        System.out.println(trainSet.size());
    }
}

