package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b && b == c) {
            System.out.println(10000 + (a * 1000));
        } else if (a == b || b == c || c == a) {
            if (a == b) {
                System.out.println(1000 + (a * 100));
            } else if (c == b) {
                System.out.println(1000 + (c * 100));
            } else if (a == c) {
                System.out.println(1000 + (a * 100));
            }
        } else {
            int max = (((a > b) ? a : b) > c) ? ((a > b) ? a : b) : c;
            System.out.println(max * 100);
        }
    }
}
