import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 바구니의 수
        int M = Integer.parseInt(st.nextToken()); // 바꾸는 횟수

        int[] baskets = new int[N+1];

        // 바구니 번호 초기화
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }

        // M번 바구니 순서 바꾸기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 바구니 순서 바꾸기
            int[] temp = new int[end - start + 1];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = baskets[start + j];
            }
            for (int j = 0; j < temp.length; j++) {
                baskets[start + j] = temp[temp.length - 1 - j];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}
