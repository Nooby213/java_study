package Silver;

import java.util.*;
import java.io.*;

public class Silver_11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> node = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            node.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node.get(a).add(b);
            node.get(b).add(a);
        }
        int[] visited = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Integer next : node.get(now)) {
                if (visited[next] == 0) {
                    visited[next] = now;
                    q.add(next);
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.println(sb);
    }
}