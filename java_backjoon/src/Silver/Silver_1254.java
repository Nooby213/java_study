package Silver;

import java.io.*;

public class Silver_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        StringBuilder sb;
        for (int i = 0; i < len; i++) {
            sb = new StringBuilder(s);
            for (int j = i - 1; j >= 0; j--) {
                sb.append(s.charAt(j));
            }
            if (isPel(sb.length(), String.valueOf(sb))) {
                System.out.println(sb.length());
                return;
            }

        }

    }

    static boolean isPel(int len, String s) {
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
