package Silver;

import java.util.*;

public class Silver_15649 {
    static boolean[] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        comb(0, new StringBuilder());
    }

    static void comb(int cnt, StringBuilder sb) {
        if (cnt == m) {
            System.out.println(sb);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                StringBuilder newSb = new StringBuilder(sb);
                comb(cnt + 1, newSb.append(i).append(" "));
                // 안되는 코드
//                comb(cnt + 1, new StringBuilder(sb.append(i).append(" ")));
                // 되는 코드 (복사하는 값에 붙여넣으면 원본인 sb가 바껴서 들어감)
//                comb(cnt + 1, new StringBuilder(sb).append(i).append(" "));
                visited[i] = false;
            }
        }
    }
}



