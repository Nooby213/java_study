package platinum;

import java.util.*;

public class Platinum_17071 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[][] visited = new boolean[500001][2]; // 방문 확인 배열

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n][0] = true;
        int t = 0;

        while (!q.isEmpty()) {
            k += t;
            if (k > 500000) break;

            if (visited[k][t % 2]) {
                System.out.println(t);
                return;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                for (int next : new int[]{now - 1, now + 1, now * 2}) {
                    if (next >= 0 && next <= 500000 && !visited[next][(t + 1) % 2]) {
                        visited[next][(t + 1) % 2] = true;
                        q.add(next);
                    }
                }
            }
            t++;
        }
        System.out.println(-1);
    }
}

