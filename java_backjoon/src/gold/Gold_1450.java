package gold;

import java.util.*;
import java.io.*;

public class Gold_1450 {
    static int n;
    static int c;
    static long[] bag;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        bag = new long[n];
        for (int i = 0; i < n; i++) {
            bag[i] = Long.parseLong(st.nextToken());
        }

        List<Long> leftArr = new ArrayList<>();
        List<Long> rightArr = new ArrayList<>();
        comb(0, n / 2, 0, leftArr);
        comb(n / 2, n, 0, rightArr);

        Collections.sort(leftArr);
        Collections.sort(rightArr);

        int rightSize = rightArr.size();
        long cnt = 0;
        for (Long l : leftArr) {
            int can = (int) (c - l);
            int left = 0;
            int right = rightSize;
            while (left < right) {
                int mid = (left + right) / 2;
                if (rightArr.get(mid) <= can) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            cnt += left;
        }

        System.out.println(cnt);
    }

    static void comb(int start, int end, long tempSum, List<Long> arr) {
        if (start == end) {
            if (tempSum <= c) {
                arr.add(tempSum);
            }
            return;
        }
        comb(start + 1, end, tempSum, arr);
        comb(start + 1, end, tempSum + bag[start], arr);
    }
}

