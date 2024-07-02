package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Gold_2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] home = new int[n];
        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int left = 1;
        int right = home[n - 1] - home[0] + 1;
        int mid = 0;
        ;
        int cnt = 1;

        while (left < right) {
            mid = (left + right) / 2;
            cnt = 1;

            int before = 0;

            for (int i = 1; i < n; i++) {
                int dis = home[i] - home[before];
                if (dis >= mid) {
                    cnt++;
                    before = i;
                }
            }

            if (cnt < c) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        System.out.println(left - 1);
    }
}
