package gold;
import java.util.*;
import java.io.*;

public class Gold_1062_Visited {
    static int n;
    static int k;
    static int max = Integer.MIN_VALUE;
    static String[] words;
    static boolean[] learned;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            word = word.replace("anta", "");
            word = word.replace("tica", "");
            words[i] = word;
        }
        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }
        // 알파벳 총 26개, 'a'를 뺀값이 인덱스
        learned = new boolean[26];
        learned['a' - 'a'] = true;
        learned['c' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;

        learn(0, 0);
        System.out.println(max);
    }

    static void learn(int alpha, int size) {
        // 배울 수 있는 단어 갯수만큼 다 배웠다면 개수 조회
        if (size == k - 5) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                boolean know = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!learned[words[i].charAt(j) - 'a']) {
                        know = false;
                        break;
                    }
                }
                if (know) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }
        // a부터 z까지 배우거나 안배웠을때 경우 조사
        for (int i = alpha; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                learn(i, size + 1);
                learned[i] = false;
            }
        }
    }
}
