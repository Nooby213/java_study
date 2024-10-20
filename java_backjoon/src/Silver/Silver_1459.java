package Silver;

import java.util.*;
import java.io.*;

public class Silver_1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long min = Math.min(x, y);
        long max = Math.max(x, y);
        long diff = Math.abs(x - y);
        long result;

        if (w * 2 <= s) {
            result = w * (x + y);
        } else if (w >= s) {
            if (diff % 2 == 0) {
                result = s * max;
            } else {
                result = s * (max - 1) + w;
            }
        } else {
            result = s * min + diff * w;
        }

        System.out.println(result);
    }
}
