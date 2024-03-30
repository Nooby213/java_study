import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int sum = 0;
        for (String a : alpha) {
            word = word.replace(a, "0");
        }
        System.out.println(word.length());
    }
}
