package gold;
import java.util.*;
import java.io.*;

public class Gold_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<int[]>> way = new ArrayList<>();
        List<List<int[]>> backWay = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            way.add(new ArrayList<>());
            backWay.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            way.get(s).add(new int[]{e, t});
            backWay.get(e).add(new int[]{s, t});
        }

        // x에서 다른 모든 정점으로 가는 최단 경로
        int[] fromX = dijkstra(n, x, way);
        // 다른 모든 정점에서 x로 가는 최단 경로
        int[] toX = dijkstra(n, x, backWay);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i != x) {
                max = Math.max(max, toX[i] + fromX[i]);
            }
        }
        System.out.println(max);
    }

    private static int[] dijkstra(int n, int start, List<List<int[]>> way) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowEnd = now[0];
            int nowDist = now[1];

            if (visited[nowEnd]) continue;
            visited[nowEnd] = true;

            for (int[] next : way.get(nowEnd)) {
                int nextEnd = next[0];
                int nextDist = nowDist + next[1];

                if (!visited[nextEnd] && nextDist < dist[nextEnd]) {
                    dist[nextEnd] = nextDist;
                    pq.add(new int[]{nextEnd, nextDist});
                }
            }
        }
        return dist;
    }
}
