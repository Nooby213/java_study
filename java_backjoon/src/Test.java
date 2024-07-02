import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Bus>> bus = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            bus.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bus.get(s).add(new Bus(e, c));
        }

        System.out.println(bus);
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;

        PriorityQueue<Bus> pq = new PriorityQueue<>(Comparator.comparing(b -> b.cost));
        pq.add(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus now = pq.poll();
            int nowEnd = now.end;
            int nowCost = now.cost;

            if (nowCost > cost[nowEnd]) {
                continue;
            }

            for (Bus next : bus.get(nowEnd)) {
                int nextEnd = next.end;
                int nextCost = nowCost + next.cost;

                if (nextCost < cost[nextEnd]) {
                    cost[nextEnd] = nextCost;
                    pq.add(new Bus(nextEnd, nextCost));
                }
            }
        }

        System.out.println(cost[end]);

    }

    static class Bus {
        int end;
        int cost;

        public Bus(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return end + "," + cost;
        }
    }
}

