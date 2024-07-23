package gold;

import java.util.*;
import java.io.*;

public class Gold_3584 {
    static int[] node;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            node = new int[n + 1];
            for (int j = 0; j < n - 1; j++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                node[c] = p;
            }
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            goToParent(a, b);
        }
    }

    static void goToParent(int a, int b) {
        int[] visited = new int[n + 1];
        Deque<Integer> dq = new LinkedList<>();
        dq.add(a);
        dq.add(b);
        while (!dq.isEmpty()) {
            int now = dq.pollFirst();
            visited[now]++;
            if (visited[now] == 2) {
                System.out.println(now);
                return;
            }
            if (node[now] != 0) {
                dq.addLast(node[now]);
            }
        }
    }
}

