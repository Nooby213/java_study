package gold;
import java.util.*;

public class Gold_9663 {
    static int n;
    static int total = 0;
    static int[] col;
    static int[] row;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new int[n];
        queen(0);
        System.out.println(total);
    }

    static void queen(int row) {
        // 마지막 행까지 다 놨으면
        if (row == n) {
            total++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // i번재 열에 퀸을 놓을 수 있으면
            col[row] = i;
            if (possible(row)) {
                queen(row + 1);
            }
        }
    }

    static boolean possible(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있거나 대각선에 있으면 안 됨
            if (col[i] == col[row] || Math.abs(col[i] - col[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}