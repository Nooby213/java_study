import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int total = 0;
    static boolean[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board = new boolean[n][n];
                visited = new boolean[n][n];
                queen(i, j, 1);
            }
        }
        System.out.println(total);
    }

    static void queen(int i, int j, int cnt) {
        possible(i, j);
        if (cnt == n) {
            total++;
            System.out.println(Arrays.deepToString(board));
            System.out.println(Arrays.deepToString(visited));
            return;
        }
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if (!visited[k][l] && !board[k][l]) {
                    queen(k, l, cnt + 1);

                    System.out.println(i + " " +  j + " " + k + " " + l);
                }
            }
        }
    }
    static int del;
    static int[] di = {-del, del, del, -del};
    static int[] dj = {del, del, -del, -del};
    static void possible(int i, int j) {
        board[i][j] = true;
        for (int k = 0; k < 4; k++) {
            for (del = 1; del <= 8; del++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (0 <= ni && ni < n && 0 <= nj && nj < n) {
                    board[ni][nj] = true;
                } else {
                    break;
                }

            }
        }
    }
}