package Silver;
import java.util.*;

public class Silver_15650 {
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        comb(0, 1, new StringBuilder());
    }

    static void comb(int cnt, int i, StringBuilder sb) {
        if (cnt == m) {
            System.out.println(sb);
            return;
        }
        if(i > n) {
            return;
        }
        comb(cnt + 1, i + 1, new StringBuilder(sb).append(i).append(' '));
        comb(cnt, i + 1, new StringBuilder(sb));
    }
}




