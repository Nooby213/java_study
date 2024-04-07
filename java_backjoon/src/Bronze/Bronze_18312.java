package Bronze;

import java.util.Scanner;

public class Bronze_18312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String K = String.valueOf(sc.nextInt());

        int cnt = 0;
        for (int i = 0; i <= N; i++) {
            String h;
            if (i < 10) {
                h = "0" + i;
            } else {
                h = String.valueOf(i);
            }
            for (int j = 0; j < 60; j++) {
                String m;
                if (j < 10) {
                    m = "0" + j;
                } else {
                    m = String.valueOf(j);
                }
                for (int k = 0; k < 60; k++) {
                    String s;
                    if (k < 10) {
                        s = "0" + k;
                    } else {
                        s = String.valueOf(k);
                    }
                    if (h.contains(K) || m.contains(K) || s.contains(K)) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
