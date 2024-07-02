package Silver;

import java.io.*;

public class Silver_1992 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static String[] quad;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        quad = new String[n];
        for (int i = 0; i < n; i++) {
            quad[i] = br.readLine();
        }
        quadTree(0, 0, n);
        System.out.println(sb);
    }

    static void quadTree(int y, int x, int N) {
        char startChar = quad[y].charAt(x);
        // 쿼드 트리가 아니라면 다시 1/4로 나눠서 검사
        if (!isQuadTree(y, x, N, startChar)) {
            sb.append("(");
            quadTree(y, x, N / 2);
            quadTree(y, x + N / 2, N / 2);
            quadTree(y + N / 2, x, N / 2);
            quadTree(y + N / 2, x + N / 2, N / 2);
            sb.append(")");
        }
    }

    static boolean isQuadTree(int y, int x, int N, char startChar) {
        for (int i = y; i < y + N; i++) {
            for (int j = x; j < x + N; j++) {
                if (startChar != quad[i].charAt(j)) {
                    return false;
                }
            }
        }
        sb.append(startChar);
        return true;
    }
}
