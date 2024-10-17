package Silver;

import java.util.*;
import java.io.*;

public class Silver_2193 {
    static long[] pn = new long[91];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pn[1] = 1;
        pn[2] = 1;
        pn[3] = 2;
        for (int i = 4; i <= n; i++) {
            pn[i] = pn[i - 1] + pn[i - 2];
        }
        System.out.println(pn[n]);
    }
}
