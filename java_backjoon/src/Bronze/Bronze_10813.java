import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N 개의 바구니, 1 ≤ N ≤ 100
        int N = Integer.parseInt(st.nextToken());
        // M번 공 바꿈, 1 ≤ M ≤ 100
        int M = Integer.parseInt(st.nextToken());
        int[] baskets = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new  StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int temp = baskets[start];
            baskets[start] = baskets[end];
            baskets[end] = temp;
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}
