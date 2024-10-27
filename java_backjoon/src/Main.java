import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] jewels = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i][0] = m;
            jewels[i][1] = v;
        }
        Arrays.sort(jewels, (a, b) -> Integer.compare(a[0], b[0]));

        Integer[] bags = new Integer[k];
        for (int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            bags[k] = c;
        }
        Arrays.sort(bags, Comparator.reverseOrder());
        int size = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] jewel : jewels) {
            int m = jewel[0];
            int v = jewel[1];

//            if (m > c) continue;

            if (size + 1 > k) {
                if (pq.peek() < v) {
                    pq.poll();
                    pq.add(v);
                }
            } else {
                pq.add(v);
                size++;
            }
        }

        long sum = 0;
        for (Integer i : pq) {
            sum += (long) i;
        }
        System.out.println(sum);
    }
}

