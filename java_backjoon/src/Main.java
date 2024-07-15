import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int min = 100001;
        int[] arr = new int[2 * k + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[n] = 0;
        for (int i = n; i <= k; i++) {
            if (i == 0) {
                arr[i + 1] = 1;
            } else {

                arr[i - 1] = Math.min(arr[i - 1], arr[i] + 1);
                arr[i + 1] = Math.min(arr[i + 1], arr[i] + 1);
                arr[i * 2] = Math.min(Math.min(arr[i], arr[i - 1] + 1), arr[i + 1] + 1);

            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[k]);

    }
}
