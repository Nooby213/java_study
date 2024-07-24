package gold;
import java.util.*;
import java.io.*;

public class Gold_1504 {
    static int n;
    static List<List<Node>> node;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        node = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            node.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            node.get(a).add(new Node(b, w));
            node.get(b).add(new Node(a, w));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = go(1, v1);
        int path2 = go(v1, v2);
        int path3 = go(v2, n);

        int path4 = go(1, v2);
        int path5 = go(v2, v1);
        int path6 = go(v1, n);

        long result1 = (long) path1 + path2 + path3;
        long result2 = (long) path4 + path5 + path6;

        long result = Math.min(result1, result2);

        if (result >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int dis;

        public Node(int to, int dis) {
            this.to = to;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dis, o.dis);
        }
    }

    static int go(int from, int to) {
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[from] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(from, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.dis > visited[now.to]) continue;

            for (Node next : node.get(now.to)) {
                if (now.dis + next.dis < visited[next.to]) {
                    visited[next.to] = now.dis + next.dis;
                    pq.add(new Node(next.to, visited[next.to]));
                }
            }
        }
        return visited[to];
    }
}

