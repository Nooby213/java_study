import java.util.*;
import java.io.*;

public class Silver_2503_Set {
    static Set<String> candidates = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // set 만듦
        generateCandidates();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 아웃이면 할 필요없음
            if (s + b > 0) {
                possibleSet(num, s, b);
            } else {
                impossibleSet(num);
            }
        }
        System.out.println(candidates.size());
    }

    // 가능한 숫자 추론
    static void possibleSet(String num, int s, int b) {
        Set<String> tempSet = new HashSet<>();
        for (int i = 123; i <= 987; i++) {
            int strike = 0;
            int ball = 0;
            String temp = String.valueOf(i);
            for (int j = 0; j < 3; j++) {
                if (temp.charAt(j) == num.charAt(j)) {
                    strike++;
                } else if (num.contains(String.valueOf(temp.charAt(j)))) {
                    ball++;
                }
            }
            // strike와 ball의 개수가 주어진 s와 b를 초과하면 해당 숫자는 후보에서 제외
            if (strike == s && ball == b) {
                tempSet.add(temp);
            }
        }
        // 모든 경우에 대해 candidates를 tempSet과의 교집합으로 갱신
        candidates.retainAll(tempSet);
    }

    static void impossibleSet(String num) {
        Set<String> tempSet = new HashSet<>();
        for (int i = 123; i <= 987; i++) {
            int cnt = 0;
            String temp = String.valueOf(i);
            for (int j = 0; j < 3; j++) {
                if (num.contains(String.valueOf(temp.charAt(j)))) {
                    cnt++;
                }
            }
            // strike와 ball의 개수가 주어진 s와 b를 초과하면 해당 숫자는 후보에서 제외
            if (cnt != 0) {
                tempSet.add(temp);
            }
        }
        // 모든 경우에 대해 candidates를 tempSet과의 교집합으로 갱신
        candidates.removeAll(tempSet);
    }
    // 모든 경우의 수
    static void generateCandidates() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i != j && j != k && i != k) {
                        candidates.add(Integer.toString(i * 100 + j * 10 + k));
                    }
                }
            }
        }
    }
}