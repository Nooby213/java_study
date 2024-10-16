package Bronze;

import java.util.*;
import java.io.*;

public class Bronze_2204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.println(sb);
                return;
            }
            PriorityQueue<String> pq = new PriorityQueue<>(String::compareToIgnoreCase);
            for (int i = 0; i < n; i++) {
                pq.add(br.readLine());
            }
            sb.append(pq.peek()).append("\n");
        }
    }
}
