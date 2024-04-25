package gold;
import java.util.*;
import java.io.*;

public class Gold_2580 {
    static int[][] sdoku = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        play(0, 0);

    }

    static void play(int i, int j) {
        if (i == 9) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 9; k++) {
                for (int l = 0; l < 9; l++) {
                    sb.append(sdoku[k][l] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if (sdoku[i][j] == 0) {
            for (int k = 1; k <= 9; k++) {
                sdoku[i][j] = k;
                if (row(i, j) && col(i, j) && square(i, j)) {
                    if (j + 1 < 9) {
                        play(i, j + 1);
                        sdoku[i][j] = 0;
                    } else {
                        play(i + 1, 0);
                        sdoku[i][j] = 0;
                    }
                }
                sdoku[i][j] = 0;
            }
        } else {
            if (j + 1 < 9) {
                play(i, j + 1);
            } else {
                play(i + 1, 0);
            }
        }
    }
    static boolean row(int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (j != k && sdoku[i][k] == sdoku[i][j]) {
                return false;
            }
        }
        return true;
    }

    static boolean col(int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (i != k && sdoku[k][j] == sdoku[i][j]) {
                return false;
            }
        }
        return true;
    }

    static boolean square(int i, int j) {
        for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
            for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
                if (i != k || j != l) {  // 문제가 되는 부분
                    if (sdoku[k][l] == sdoku[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}