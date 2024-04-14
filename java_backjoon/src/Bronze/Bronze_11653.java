package Bronze;
import java.util.*;

public class Bronze_11653 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 2;
        while (n > 1) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
            i++;
        }
    }
}