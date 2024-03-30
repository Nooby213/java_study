import java.io.IOException;
import java.util.Scanner;

public class Bronze_2444 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 위
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //아래
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
