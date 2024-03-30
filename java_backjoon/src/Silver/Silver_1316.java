package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver_1316 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // T번 반복
        int T = Integer.parseInt(br.readLine());
        // 그룹 단어 개수
        int cnt = 0;
        for (int i = 0; i < T; i++) {
            if (isGroupWord(br.readLine())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static boolean isGroupWord(String word) {
        // 소문자 알파벳 26자
        boolean[] visited = new boolean[26];
        // 첫 값을 초기값으로 입력
        char temp = word.charAt(0);
        visited[temp - 'a'] = true;
        for (int i = 1; i < word.length(); i++) {
            char now = word.charAt(i);
            // 지금 단어와 전의 단어 비교
            if (temp != now) {
                // 나왔던 단어라면 false 리턴
                if (visited[now - 'a']) {
                    return false;
                }
                // 아니라면
                visited[now - 'a'] = true;
                temp = now;
            }
        }
        return true;
    }
}
