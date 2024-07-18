package gold;

import java.io.*;
import java.util.*;

public class Gold_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        int minSum = Integer.MAX_VALUE;
        int minLeft = left;
        int minRight = right;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                minLeft = left;
                minRight = right;
            }

            if (sum > 0) {
                right--;
            } else if (sum == 0) {
                System.out.println(arr[minLeft] + " " + arr[minRight]);
                return;
            } else {
                left++;
            }
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}

