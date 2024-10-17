package Silver;

import java.util.*;
import java.io.*;

public class Silver_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < n -1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
