package Bronze;
import java.util.*;
import java.io.*;

public class Bronze_5086 {
    static int a, b;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) {
                return;
            }
            relation(a, b);
        }
    }

    static void relation(int a, int b) {
        if (b % a == 0) {
            System.out.println("factor");
        } else if (a % b == 0) {
            System.out.println("multiple");
        } else {
            System.out.println("neither");
        }
    }
}