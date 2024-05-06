package gold;
import java.util.*;
import java.io.*;

public class Gold_11054 {
    static int n;
    static int[] arr;
    static int[] dpFront;
    static int[] dpBack;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 처음부터 작은 순서대로 + 끝에서 작은 순서대로
        dpFront = new int[n];
        dpBack = new int[n];
        // 최대값 초기화
        int max = 0;
        // 처음부터 작은 순서대로
        for (int i = 0; i < n; i++) {
            int tempMax = 0;
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    tempMax = Math.max(tempMax, dpFront[j] + 1);
                }
            }
            dpFront[i] = tempMax;
        }
        // 뒤에서 작은 순서대로
        for (int i = n - 1; i >= 0; i--) {
            int tempMax = 0;
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]) {
                    tempMax = Math.max(tempMax, dpBack[j] + 1);
                }
            }
            dpBack[i] = tempMax;
            max = Math.max(max, dpFront[i] + dpBack[i]);
        }
        // 본인을 제외하기 때문에 + 1
        System.out.println(max + 1);
    }
}
