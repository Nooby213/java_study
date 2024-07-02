package gold;

import java.io.*;
import java.util.*;


public class Gold_12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        int len = 1;

        for (int i = 1; i < n; i++) {

            int now = arr[i];

            if (lis[len - 1] < now) {
                lis[len] = now;
                len++;
            } else {
                int left = 0;
                int right = len;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (lis[mid] < now) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                lis[left] = now;
            }
        }
        System.out.println(len);
    }
}
