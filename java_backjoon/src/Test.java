import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = n / 5;
        while (a >= 0) {
            int i = n - 5 * a;
            if (i % 2 == 0) {
                System.out.println(i / 2 + a);
                return;
            }
            a--;
        }
        System.out.println(-1);
    }
}
