package Silver;

import java.io.*;

public class Silver_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[500_001];

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[value]++;
        }

        long sum = 0;
        int j = 1;

        for (int i = 1; i < arr.length; i++) {
            while (arr[i] > 0) {
                arr[i]--;
                sum += Math.abs(i - j++);
            }
        }

        System.out.println(sum);
    }
}
