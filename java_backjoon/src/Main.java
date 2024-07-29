import java.util.*;
import java.io.*;

public class Main {
    static int[] sis = new int[500001];
    static int[] subin = new int[500001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int t = 1;
        while (k < 500001) {
            sis[k] = t;
            k += t;
            t++;
        }
        System.out.println(Arrays.toString(sis));
    }

    static void move(int now, int time) {
        if (now < 0) {
            return;
        }
        if (now > 500000) {
            return;
        }
        if (subin[now] < time) {
            return;
        }
        subin
    }
}
