package gold;
import java.util.Scanner;

public class Gold_9251 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        int word1_len = word1.length();
        int word2_len = word2.length();
        int[][] idx = new int[word1_len + 1][word2_len + 1];

        for (int i = 1; i <= word1_len; i++) {
            for (int j = 1; j <= word2_len; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 자기보다 앞에 있는 문자열의 합과 더 해줘야함
                    idx[i][j] = idx[i - 1][j - 1] + 1;
                } else {
                    idx[i][j] = Math.max(idx[i - 1][j], idx[i][j - 1]);
                }
            }
        }
        System.out.println(idx[word1_len][word2_len]);
    }
}
