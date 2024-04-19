package Silver;

import java.util.*;

public class Silver_15651 {
    static int n;
    static int m;
    static StringBuilder total = new StringBuilder();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        comb(0, new StringBuilder());
        System.out.println(total);
    }

    static void comb(int cnt, StringBuilder sb) {
        if (cnt == m) {
            total.append(sb).append('\n');
            return;
        }
        for (int j = 1; j <= n; j++) {
            comb(cnt + 1, new StringBuilder(sb).append(j).append(" "));
        }
    }
}