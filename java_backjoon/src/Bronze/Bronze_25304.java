package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // X = 금액, 1 <= X <= 1,000,000,000
        int X = Integer.parseInt(br.readLine());
        int items = Integer.parseInt(br.readLine());
        int total = 0;
        for (int i = 0; i < items; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int item_num = Integer.parseInt(st.nextToken());
            total += price * item_num;
        }
        if (total == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
