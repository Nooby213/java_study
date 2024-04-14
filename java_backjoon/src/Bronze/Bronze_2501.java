package Bronze;
import java.util.*;

public class Bronze_2501 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Integer> factors = new LinkedList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        if (factors.size() < k) {
            System.out.println(0);
        } else {
            System.out.println(factors.get(k - 1));
        }
    }
}