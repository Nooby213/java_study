package Silver;
import java.util.*;
import java.io.*;

public class Silver_16139 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] cnt = new int[26][word.length() + 1];
        StringBuilder sb = new StringBuilder();
        cnt[word.charAt(0) - 'a'][1] = 1;

        for (int i = 0; i < 26; i++) {
            for (int j = 2; j <= word.length(); j++) {
                if (word.charAt(j - 1) - 'a' == i) {
                    cnt[i][j] = cnt[i][j - 1] + 1;
                } else {
                    cnt[i][j] = cnt[i][j - 1];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(cnt[a - 'a'][end + 1] - cnt[a - 'a'][start]).append('\n');
        }
        System.out.println(sb);
    }
}
