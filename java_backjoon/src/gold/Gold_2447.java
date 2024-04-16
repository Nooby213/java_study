package gold;
import java.util.*;
import java.io.*;

public class Gold_2447 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }

        star(n,0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void star(int size, int y, int x) {
        if (size == 1) {
            arr[y][x] = '*';
            return;
        }
        int newSize = size / 3;

        star(newSize,y, x);
        star(newSize, y, x + newSize);
        star(newSize, y, x + 2 * newSize);
        star(newSize, y + newSize, x);
        star(newSize, y + newSize, x + 2 * newSize);
        star(newSize,y + 2 * newSize, x);
        star(newSize, y + 2 * newSize, x + newSize);
        star(newSize, y + 2 * newSize, x + 2 * newSize);
    }
}



