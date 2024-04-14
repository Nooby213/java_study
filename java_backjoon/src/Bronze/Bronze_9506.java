package Bronze;
import java.util.*;

public class Bronze_9506 {
    static List<Integer> factors;
    static int n;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            if (n == -1) {
                return;
            }
            isPerfect(n);
        }
    } static void isPerfect(int n) {
        factors = new LinkedList<>();
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                factors.add(i);
                sum += i;
            }
        }
        if (sum == n) {
            System.out.print(n + " = ");
            for (int i = 0; i < factors.size(); i++) {
                if (i == factors.size() - 1) {
                    System.out.println(factors.get(i));
                } else {
                    System.out.print(factors.get(i) + " + ");
                }
            }
        } else {
            System.out.println(n + " is NOT perfect.");
        }
    }
}