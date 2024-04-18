import java.util.*;
import java.io.*;

public class Main {
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
//                StringBuilder newSb = new StringBuilder(sb);
//                comb(cnt + 1, newSb.append(i).append(" "));
                comb(cnt + 1, new StringBuilder(sb).append(i).append(" "));
                visited[i] = false;
            }
        }
    }
}



