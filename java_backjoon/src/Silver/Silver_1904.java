package Silver;
import java.util.*;

public class Silver_1904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bin = new int[n + 3];
        bin[1] = 1;
        bin[2] = 2;
        bin[3] = 3;
        if (n > 3) {
            for (int i = 3; i <= n; i++) {
                bin[i] = (bin[i - 1] + bin[i - 2]) % 15746;
            }
        }
        System.out.println(bin[n]);
    }
}
