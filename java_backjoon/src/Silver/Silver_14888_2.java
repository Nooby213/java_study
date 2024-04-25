package Silver;

import java.util.*;
import java.io.*;

public class Silver_14888_2 {
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        // 숫자 arr
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 연산자 개수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        cal(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void cal(int i, int temp) {
        if (i == n) {
            max = Math.max(temp, max);
            min = Math.min(temp, min);
            return;
        }
        for (int j = 0; j < 4; j++) {
            if (operator[j] > 0) {
                operator[j]--;
                if (j == 0) {
                    cal(i + 1, temp + arr[i]);
                } else if (j == 1) {
                    cal(i + 1, temp - arr[i]);
                } else if (j == 2) {
                    cal(i + 1, temp * arr[i]);
                } else {
                    cal(i + 1, temp / arr[i]);
                }
                operator[j]++;
            }
        }
    }
}