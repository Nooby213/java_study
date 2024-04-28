package Silver;
import java.util.*;

public class Silver_10844 {
    static Long sum = 0L;
    static int n;
    static int mod = 1000000000;
    static List<Long> temp;

    static List<Long> start = new ArrayList<>();
    static {
        for (int i = 0; i < 10; i++) {
            start.add(1L);
        }
    }
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            stairNum(i);
        }
        for (int i = 1; i < 10; i++) {
            sum += temp.get(i);
        }
        System.out.println(sum % mod);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static void stairNum(int i) {
        if (i == 0) {
            temp = new ArrayList<>(start);
            return;
        }
        List<Long> arr = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            if (j == 0) {
                arr.add(temp.get(1) % mod);
            } else if (j == 9) {
                arr.add(temp.get(8) % mod);
            } else {
                arr.add((temp.get(j + 1) + temp.get(j - 1)) % mod);
            }
        }
        temp = new ArrayList<>(arr);
    }
}