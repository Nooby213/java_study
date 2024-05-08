import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        int[] sum = new int[n];
        int cnt = 1;
        st = new StringTokenizer(br.readLine());
        numbers[0] = Integer.parseInt(st.nextToken());
        sum[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sum[i] = numbers[i] + sum[i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tempSum = sum[j] - sum[j - i];
                if (tempSum % m == 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
