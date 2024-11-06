import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        List<Edge> edges = new ArrayList<>();

        public Node() {
        }

        private void add(Edge edge) {
            edges.add(edge);
        }
    }

    static class Edge {
        int end;
        int time;

        public Edge(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "end=" + end +
                    ", time=" + time +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 정점 개수
            int k = Integer.parseInt(st.nextToken()); // 간선 개수
            int[] time = new int[n + 1];

            // 시간 기록
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            List<Node> nodes = new ArrayList<>();
            // 빈 노드
            for (int i = 0; i <= n; i++) {
                nodes.add(new Node());
            }
            // 간선 연결
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                nodes.get(start).add(new Edge(end, time[start]));
            }
        }
    }
}
