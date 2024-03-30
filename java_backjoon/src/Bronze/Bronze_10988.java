import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        boolean result = true;
        int len = word.length() / 2;

        if (word.length() == 1) {
        } else if (word.length() % 2 == 1) {
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != word.charAt(len * 2 - i)) {
                    result = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != word.charAt(i + (len-i) * 2 - 1)) {
                    result = false;
                    break;
                }
            }
        }

        if (result == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
