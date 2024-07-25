import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int time;

        public Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Node>> bus = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            bus.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bus.get(a).add(new Node(b, c));
        }

        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.time > visited[now.to]) continue;

            for (Node next : bus.get(now.to)) {
                if (next.time + now.time > 0 && next.time + now.time < visited[next.to]) {
                    pq.add(new Node(next.to, next.time + now.time));
                    visited[next.to] = next.time + now.time;
                }
                if (next.time + now.time <= 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            if (visited[i] == Integer.MAX_VALUE) {
                sb.append(-1).append('\n');
            } else {
                sb.append(visited[i]).append('\n');
            }
        }
        System.out.println(sb);
    }


}

