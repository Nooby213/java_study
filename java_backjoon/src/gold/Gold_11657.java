package gold;

import java.util.*;
import java.io.*;

public class Gold_11657 {
    static class Edge {
        int from, to, time;

        public Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        boolean hasNegativeCycle = false;

        for (int i = 1; i <= n; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] != Long.MAX_VALUE && dist[edge.from] + edge.time < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.time;
                    if (i == n) {
                        hasNegativeCycle = true;
                    }
                }
            }
        }

        if (hasNegativeCycle) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Long.MAX_VALUE) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dist[i]).append('\n');
                }
            }
            System.out.print(sb);
        }
    }
}

