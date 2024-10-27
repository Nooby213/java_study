package gold;

import java.io.*;
import java.util.*;

public class Gold_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] problems = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            problems[i][0] = deadline;
            problems[i][1] = ramen;
        }

        Arrays.sort(problems, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] p : problems) {
            int deadline = p[0];
            int ramen = p[1];

            if (pq.size() + 1 > deadline) {
                if (pq.peek() < ramen) {
                    pq.poll();
                    pq.add(ramen);
                }
            } else {
                pq.add(ramen);
            }
        }

        int sum = 0;
        for (int ramen : pq) {
            sum += ramen;
        }
        System.out.println(sum);
    }
}

