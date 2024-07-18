import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long minSum = 3000000001L;
        int minLeft = 0;
        int minMid = 0;
        int minRight = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i;
            int mid = i + 1;
            int right = n - 1;

            while (mid < right) {
                long sum = (long) arr[left] + arr[mid] + arr[right];

                if (Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    minLeft = left;
                    minMid = mid;
                    minRight = right;
                }

                if (sum > 0) {
                    right--;
                }
                else if (sum == 0) {
                    System.out.println(arr[minLeft] + " " + arr[minMid] + " " + arr[minRight]);
                    return;
                }
                else {
                    mid++;
                }
            }
        }

        System.out.println(arr[minLeft] + " " + arr[minMid] + " " + arr[minRight]);
    }
}
