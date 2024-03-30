package Bronze;

import java.io.IOException;
import java.util.Scanner;

public class Bronze_25314 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N/4; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}
