package Silver;
import java.util.*;
import java.io.*;

public class Silver_14888 {
    static int[] arr;
    static boolean[] used;
    static int[] operator = new int[4];
    static List<String> opts;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        used = new boolean[n];
        opts = new LinkedList<>();
        // 숫자 arr
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 연산자 개수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        // 연산자 리스트
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < operator[i]; j++) {
                if (i == 0) {
                    opts.add("+");
                }
                if (i == 1) {
                    opts.add("-");
                }
                if (i == 2) {
                    opts.add("*");
                }
                if (i == 3) {
                    opts.add("/");
                }
            }
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
        for (int j = 0; j < n - 1; j++) {
            if (!used[j]) {
                used[j] = true;
                if (opts.get(j).equals("+")) {
                    cal(i + 1, temp + arr[i]);
                }
                if (opts.get(j).equals("-")) {
                    cal(i + 1, temp - arr[i]);
                }
                if (opts.get(j).equals("*")) {
                    cal(i + 1, temp * arr[i]);
                }
                if (opts.get(j).equals("/")) {
                    cal(i + 1, temp / arr[i]);
                }
                used[j] = false;
            }
        }
    }
}