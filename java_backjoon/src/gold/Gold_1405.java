package gold;

import java.util.*;
import java.io.*;

public class Gold_1405 {
    static char[] direction;
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[][] board = new int[29][29];
    static int move;
    static double per = 0;
    static double e;
    static double w;
    static double s;
    static double n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        move = Integer.parseInt(st.nextToken());
        e = Double.parseDouble(st.nextToken()) / 100;
        w = Double.parseDouble(st.nextToken()) / 100;
        s = Double.parseDouble(st.nextToken()) / 100;
        n = Double.parseDouble(st.nextToken()) / 100;
        direction = new char[move];

        board[14][14] = 1;
        go(0, 14, 14);
        System.out.println(per);
    }

    static void go(int m, int y, int x) {
        if (m == move) {
            double temp = 1;
            for (int i = 0; i < move; i++) {
                char dir = direction[i];
                if (dir == 'e') {
                    temp *= e;
                } else if (dir == 'w') {
                    temp *= w;
                } else if (dir == 's') {
                    temp *= s;
                } else {
                    temp *= n;
                }
            }
            per += temp;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (board[ny][nx] == 0) {
                board[ny][nx] = 1;
                if (i == 0 && w != 0) {
                    direction[m] = 'w';
                    go(m + 1, ny, nx);
                } else if (i == 1 && e != 0) {
                    direction[m] = 'e';
                    go(m + 1, ny, nx);
                } else if (i == 2 && n != 0) {
                    direction[m] = 'n';
                    go(m + 1, ny, nx);
                } else if (i == 3 && s != 0) {
                    direction[m] = 's';
                    go(m + 1, ny, nx);
                }
                board[ny][nx] = 0;

            }
        }
    }
}

