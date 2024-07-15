package gold;

import java.util.*;
import java.io.*;

public class Gold_16236 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] now = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) {
                    arr[i][j] = 0;
                } else if (temp == 9) {
                    now[0] = i;
                    now[1] = j;
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = temp;
                }
            }
        }

        int shark = 2;
        int ate = 0;
        int time = 0;

        while (true) {
            Fish toEat = findCanEat(arr, now[0], now[1], shark);
            if (toEat == null) break;

            int distance = toEat.dist;
            time += distance;
            now[0] = toEat.y;
            now[1] = toEat.x;
            arr[toEat.y][toEat.x] = 0;
            ate++;

            if (ate == shark) {
                shark++;
                ate = 0;
            }
        }

        System.out.println(time);
    }

    static Fish findCanEat(int[][] arr, int sy, int sx, int size) {
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sy, sx});
        dist[sy][sx] = 0;

        List<Fish> canEat = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (dist[ny][nx] != -1 || arr[ny][nx] > size) continue;

                dist[ny][nx] = dist[y][x] + 1;

                if (arr[ny][nx] > 0 && arr[ny][nx] < size) {
                    if (dist[ny][nx] < minDist) {
                        minDist = dist[ny][nx];
                        canEat.clear();
                        canEat.add(new Fish(ny, nx, dist[ny][nx]));
                    } else if (dist[ny][nx] == minDist) {
                        canEat.add(new Fish(ny, nx, dist[ny][nx]));
                    }
                }

                q.add(new int[] {ny, nx});
            }
        }

        if (canEat.isEmpty()) return null;

        canEat.sort((a, b) -> {
            if (a.dist == b.dist) {
                if (a.y == b.y) return Integer.compare(a.x, b.x);
                return Integer.compare(a.y, b.y);
            }
            return Integer.compare(a.dist, b.dist);
        });

        return canEat.get(0);
    }

    static class Fish {
        int y;
        int x;
        int dist;

        public Fish(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}

