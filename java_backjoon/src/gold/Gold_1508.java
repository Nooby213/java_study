package gold;

import java.util.*;
import java.io.*;

public class Gold_1508 {
    static int n, m, k;
    static String position;
    static int[] positions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 트랙 길이
        m = Integer.parseInt(st.nextToken()); // 심판 수
        k = Integer.parseInt(st.nextToken()); // 가능한 위치 수

        positions = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1, right = n;
        String bestPosition = "";

        while (left <= right) {
            int mid = (left + right) / 2;
            if (stand(mid)) {
                bestPosition = position;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(bestPosition);
    }

    static boolean stand(int pos) {
        StringBuilder sb = new StringBuilder();
        // 첫 번째 심판은 항상 배치됨
        int prePos = positions[0];
        int cnt = 1;
        sb.append(1);

        for (int i = 1; i < k; i++) {
            if (positions[i] - prePos >= pos) { // 간격이 pos 이상이면 배치 가능
                cnt++;
                sb.append(1);
                prePos = positions[i]; // 이전 심판 위치 갱신
            } else {
                sb.append(0);
            }

            // 모든 심판을 배치한 경우
            if (cnt == m) {
                // 남은 자리를 0으로 채움
                for (int j = i + 1; j < k; j++) {
                    sb.append(0);
                }
                position = sb.toString();
                return true;
            }
        }

        return false;
    }
}
