package gold;

import java.io.*;
import java.util.*;

public class Gold_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new int[]{s, e});
        }
        int cnt = 0;
        int end = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int s = cur[0];
            int e = cur[1];
            if (end < s) {
                int temp = (int) Math.ceil((double)(e - s) / l);
                cnt += temp;
                end = s + temp * l;
            } else {
                int temp = (int) Math.ceil((double) (e - end) /l);
                cnt += temp;
                end += temp * l;
            }

        }
        System.out.println(cnt);
    }
}


