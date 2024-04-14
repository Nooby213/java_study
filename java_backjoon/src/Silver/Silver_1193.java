package Silver;
import java.util.*;

public class Silver_1193 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while (((int) Math.pow(i, 2) + i) / 2 < n) {
            i++;
        }
        int gap = ((int) Math.pow(i, 2) + i) / 2 - n;
        // 짝수라면
        if (i % 2 == 0) {
            System.out.println((i - gap) + "/" + (1 + gap));
        }
        // 홀수라면
        else {
            System.out.println((1 + gap) + "/" + (i - gap));
        }
    }
}