package Silver;
import java.util.*;
import java.io.*;

public class Silver_9184 {
    static int a;
    static int b;
    static int c;
    static int[][][] arr = new int[21][21][21];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            print(a, b, c);
        }
    }

    static int w(int a, int b, int c) {
        if (arr[a][b][c] != 0) {
            return arr[a][b][c];
        } if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a < b && b < c) {
            arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            arr[a][b][c] =  w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return arr[a][b][c];
    }

    static void print(int a, int b, int c) {
        int result = 0;
        if (a <= 0 || b <= 0 || c <= 0) {
            result = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            result = w(20, 20, 20);
        } else {
            result = w(a, b, c);
        }
        System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, result);
    }
}
