package Silver;
import java.util.*;
import java.io.*;

public class Silver_11053 {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n];
        // 길이 최댓값
        int max = 1;
        // 어느 숫자를 선택해도 최소 1의 길이를 가진다.
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        // 숫자 기록
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 처음부터 시작하니까 끝에서부터 작은애들 찾아줌
        for (int i = n - 1; i >= 0; i--) {
            int tempMax = 1;
            for (int j = i; j < n; j++) {
                if (arr[i] < arr[j]) {
                    tempMax = Math.max(tempMax, dp[j] + 1);
                }
            }
            dp[i] = tempMax;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
