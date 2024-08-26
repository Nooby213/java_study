import java.io.*;
import java.util.*;

public class Main {
    static int count = -1;
    static int n;
    static int[] visited = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                visited[j] = 1;
                make(i, j, 1);
                visited[j] = 0;
                if (count >= n) {
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    static void make(int len, int num, int cnt) {
        if (count >= n) {
            return;
        }
        if (len == cnt) {
            count++;
            if (count == n) {
                for (int k = 9; k >= 0; k--) {
                    if (visited[k] == 1) {
                        sb.append(k);
                    }
                }
                System.out.println(sb);
            }
            return;
        }

        for (int i = 0; i < num; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                make(len, i, cnt + 1);
                visited[i] = 0;
            }
        }
    }
}