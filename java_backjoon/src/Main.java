import java.util.*;
import java.io.*;

public class Main {
    static int r;
    static int c;
    static int n;
    static char[][] mine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        mine = new char[r][c];
        char cnt = '0';
        for (int i = 0; i < r; i++) {
            mine[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (mine[i][j] == 'x') {
                    cnt++;
                    mine[i][j] = cnt;
                    j++;
                    while (range(i, j) && mine[i][j] == 'x') {
                        mine[i][j] = cnt;
                        j++;
                    }
                }
            }
        }
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int row = Integer.parseInt(st.nextToken()) - 1;
            if (i % 2 == 1) {
                for (int j = 0; j < c; j++) {
                    if (mine[row][j] != '.') {
                        mine[row][j] = '.';
                        break;
                    }
                }
            } else {
                for (int j = c - 1; j >= 0; j--) {
                    if (mine[row][j] != '.') {
                        mine[row][j] = '.';
                        break;
                    }
                }
            }
            down();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mine[i][j] != '.') {
                    sb.append("x");
                } else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean range(int i, int j) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }

    static void down() {
        for (int k = 0; k < r; k++) {
            for (int l = 0; l < c; l++) {
                if (mine[k][l] != '.' && canDown(k + 1, l)) {
                    int startL = l;
                    char cur = mine[k][l];
                    boolean can = true;
                    while (range(k, ++l) && mine[k][l] == cur) {
                        if (mine[k + 1][l] != '.') {
                            can = false;
                            break;
                        }
                    }
                    if (can) {
                        for (int i = startL; i < l; i++) {
                            mine[k][i] = '.';
                            mine[k + 1][i] = cur;
                        }
                    }
                }
            }
        }
    }

    static boolean canDown(int i, int j) {
        return i < r && mine[i][j] == '.';
    }
}
