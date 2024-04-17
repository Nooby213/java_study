package gold;
import java.io.*;

public class Gold_11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 횟수가 2의 n제곱 씩 증가함
        sb.append((int) Math.pow(2, n) - 1).append('\n');
        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }
        hanoi(n - 1, start, to, mid);
        sb.append(start + " " + to + "\n");
        hanoi(n - 1, mid, start, to);
    }
}



