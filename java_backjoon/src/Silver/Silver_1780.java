package Silver;
import java.util.*;
import java.io.*;

public class Silver_1780 {
    static int[][] paper;
    static int cntPlus = 0;
    static int cntMinus = 0;
    static int cntZero = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, n);
        System.out.println(cntMinus);
        System.out.println(cntZero);
        System.out.println(cntPlus);
    }

    static void cut(int y, int x, int N) {
        if (N == 1) {
            switch (paper[y][x]) {
                case -1:
                    cntMinus++;
                    return;
                case 1:
                    cntPlus++;
                    return;
                case 0:
                    cntZero++;
                    return;
            }
        }

        int number = paper[y][x];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i + y][j + x] != number) {
                    for (int k = 0; k < 9; k++) {
                        int[] dy = {0, 0, 0, N / 3, N / 3, N / 3, 2 * N / 3, 2 * N / 3, 2 * N / 3};
                        int[] dx = {0, N / 3, 2 * N / 3, 0, N / 3, 2 * N / 3, 0, N / 3, 2 * N / 3};
                        cut(y + dy[k], x + dx[k], N / 3);
                    }
                    return;
                }
            }
        }
        switch (number) {
            case -1:
                cntMinus++;
                return;
            case 1:
                cntPlus++;
                return;
            case 0:
                cntZero++;
                return;
        }
    }
}
