package platinum;
import java.util.*;
import java.io.*;


public class Platinum_6549 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            if (n == 0) {
                System.out.println(sb);
                return;
            }

            Stack<long[]> stack = new Stack<>();

            long maxArea = 0;
            for (long i = 0; i < n; i++) {

                long tempHeight = Long.parseLong(st.nextToken());

                while (!stack.isEmpty() && stack.peek()[1] > tempHeight) {
                    long[] last = stack.pop();
                    long width = stack.isEmpty() ? i : i - stack.peek()[0] - 1;
                    maxArea = Math.max(maxArea, last[1] * width);
                }

                stack.push(new long[]{i, tempHeight});

            }
            while (!stack.isEmpty()) {
                long[] last = stack.pop();
                long width = stack.isEmpty() ? n : n - stack.peek()[0] - 1;
                maxArea = Math.max(maxArea, last[1] * width);
            }

            sb.append(maxArea).append("\n");
        }
    }
}
