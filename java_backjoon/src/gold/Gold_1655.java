package gold;

import java.util.*;
import java.io.*;

public class Gold_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                left.add(Integer.parseInt(br.readLine()));
            } else {
                right.add(Integer.parseInt(br.readLine()));
            }
            int l = left.peek();
            int r = right.isEmpty() ? 1000000 : right.peek();
            if (l > r) {
                right.add(left.poll());
                left.add(right.poll());
            }
            sb.append(left.peek() + "\n");
        }
        System.out.println(sb);
    }
}
