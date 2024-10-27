package gold;

import java.io.*;
import java.util.*;

public class Gold_3109 {
    static int r;
    static int c;
    static int cnt;
    static int[] dy = new int[]{-1, 0, 1};
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        cnt = 0;
        for (int i = 0; i < r; i++) {
            if (connect(0, i)) cnt++;
        }
        System.out.println(cnt);
    }

    static boolean connect(int x, int y) {
        if (x == c - 1) return true;

        board[y][x] = 'x';

        int nx = x + 1;
        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            if (range(nx, ny)) {
                if (connect(nx, ny)) return true;
            }
        }

        return false;
    }

    static boolean range(int nx, int ny) {
        return ny >= 0 && ny < r && board[ny][nx] == '.';
    }
}
