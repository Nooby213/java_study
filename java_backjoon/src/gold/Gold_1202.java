package gold;

import java.io.*;
import java.util.*;

public class Gold_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> jewels = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new int[]{m, v});
        }
        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for (int j = 0; j < k; j++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (!bags.isEmpty()) {
            int bag = bags.poll();
            while (!jewels.isEmpty() && bag >= jewels.peek()[0]) {
                pq.add(jewels.poll()[1]);
            }
            if (!pq.isEmpty()) sum += pq.poll();
        }
        System.out.println(sum);
    }

}

