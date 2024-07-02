package Silver;

import java.io.*;

public class Silver_5874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int cnt = 0;
        int open = 0;

        for (int i = 1; i < len; i++) {
            if (input.charAt(i) == '(' && input.charAt(i - 1) == '(') {
                open++;
            } else if (input.charAt(i) == ')' && input.charAt(i - 1) == ')') {
                cnt += open;
            }
        }

        System.out.println(cnt);
    }
}
