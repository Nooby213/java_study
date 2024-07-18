import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if (arr[0] >= 0) {
            System.out.println(arr[0] + " " + arr[1]);

        }
        if (arr[n - 1] <= 0) {
            System.out.println(arr[n - 2] + " " + arr[n - 2]);

        }


        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int s = arr[i];
            for (int j = n - 1; j > i ; j--) {
                int e = arr[j];
                if (min > Math.abs(s + e)) {
                    start = s;
                    end = e;
                    min = Math.abs(s + e);
                } else {
                    break;
                }
            }
        }
        System.out.println(start + " " + end);
    }
}
