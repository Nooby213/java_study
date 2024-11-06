package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver_1802 {
    public static boolean isFoldable(String paper) {
        // 길이가 1이면 항상 접을 수 있음
        if (paper.length() <= 1) return true;

        int mid = paper.length() / 2;

        // 대칭이 아닐 경우 접을 수 없음
        for (int i = 0; i < mid; i++) {
            if (paper.charAt(i) == paper.charAt(paper.length() - 1 - i)) {
                return false;
            }
        }

        // 대칭이면 재귀 호출
        return isFoldable(paper.substring(0, mid)) && isFoldable(paper.substring(mid + 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String paper = br.readLine();
            if (isFoldable(paper)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
