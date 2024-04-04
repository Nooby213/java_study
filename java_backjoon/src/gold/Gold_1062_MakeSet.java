package gold;
import java.util.*;
import java.io.*;

public class Gold_1062_MakeSet {
    static List<String> words = new LinkedList<>();
    static int N;
    static int K;   // 가르칠 수 있는 알파벳 개수 K, 0 <= K <= 26
    static int maxCnt = 0;  // 배울 수 있는 단어의 최댓값

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 주어지는 단어의 개수 N, 0 < N <= 50
        N = Integer.parseInt(st.nextToken());
        // 가르칠 수 있는 알파벳 개수 K, 0 <= K <= 26
        K = Integer.parseInt(st.nextToken());
        Set<Character> antatica = new HashSet<>();
        antatica.add('a');
        antatica.add('n');
        antatica.add('t');
        antatica.add('i');
        antatica.add('c');
        // K가 5 미만이면 antatica도 못배움
        if (K < 5) {
            System.out.println(0);
        } else if (K == 26) {
            System.out.println(N);
        } else {

            // 배울 단어들 리스트만들기
            for (int i = 0; i < N; i++) {
                words.add(br.readLine());
            }
//            words.sort(Comparator.comparingInt(String::length));
            dfs(0,0,5,new HashSet<>(antatica));
            System.out.println(maxCnt);
        }
    }

    static void dfs(int n, int cnt, int len, Set<Character> aset) {
        // 단어 개수가 K보다 크다면 멈춤
        if (len > K) {
            return;
        }
        // 끝 단어까지 다 배웠다면 최대값 갱신
        if (n == N) {
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        if (cnt + N - n <= maxCnt){
            return;
        }
        // 안 배운다.
        dfs(n + 1, cnt, aset.size(), new HashSet<>(aset));
        // 배운다면 단어장에 기록
        String tempWord = words.get(n);
        for (int i = 0; i < tempWord.length(); i++) {
            aset.add(tempWord.charAt(i));
        }
        dfs(n + 1, cnt + 1, aset.size(), new HashSet<>(aset));
    }
}
