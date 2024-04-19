package Silver;
import java.util.*;

public class Silver_15652 {
    static int n;
    static int m;
    static StringBuilder total = new StringBuilder();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        comb(0, 1, new StringBuilder());
        System.out.println(total);
    }

    static void comb(int cnt, int i, StringBuilder sb) {
        if (cnt == m) {
            total.append(sb).append('\n');
            return;
        }
        for (int j = i; j <= n; j++) {
            comb(cnt + 1, j, new StringBuilder(sb).append(j).append(" "));
        }
    }
}