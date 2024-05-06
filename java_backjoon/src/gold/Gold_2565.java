package gold;
import java.util.*;
import java.io.*;

public class Gold_2565 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n];
        List<int[]> wires = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            wires.add(temp);
        }

        // temp[0] 값을 기준으로 오름차순으로 정렬
        Collections.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        // 최대값 초기화
        int max = 1;
        // A전봇대의 큰 숫자부터 꼬이지 않게 연결할 수 있는 전깃줄을 찾아 내려온다.
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i; j < n; j++) {
                if (wires.get(i)[1] < wires.get(j)[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i], max);
            }
        }
        System.out.println(n - max);
    }
}
