package Bronze;
import java.util.*;
import java.io.*;
public class Bronze_10448 {
    static int[] eureka = new int[1001];
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        eureka[1] = 1;
        for (int i = 2; i <= 1000; i++) {
            eureka[i] = i + eureka[i - 1];
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            three(a,0, 0);
            System.out.println(result);
            result = 0;
        }
    }

    static void three(int num, int cnt, int sum) {
        if (result == 1) {
            return;
        }
        if (sum >= num && cnt < 3 ){
            return;
        }
        if (cnt == 3) {
            if (sum == num){
                result = 1;
                return;
            } else {
                return;
            }

        }
        for (int i = num; i >= 1 ; i--) {
            three(num, cnt + 1, sum + eureka[i]);
        }
    }
}
