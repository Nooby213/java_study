package Bronze;

import java.util.*;
import java.io.*;

public class Bronze_10798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = new String[5];
        int[] len = new int[5];
        int max_len = 0;
        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
            len[i] = words[i].length();
            max_len = Math.max(max_len, len[i]);
        }

        for (int i = 0; i < max_len; i++) {
            for (int j = 0; j < 5; j++) {
                if (len[j] > i) {
                    System.out.print(words[j].charAt(i));
                }
            }
        }
    }
}
