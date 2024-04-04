package gold;
import java.util.*;
import java.io.*;

public class Gold_1062_Visited {
    static int n;
    static int k;
    static int max = Integer.MIN_VALUE;
    static String[] words;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();

        }

    }
}
