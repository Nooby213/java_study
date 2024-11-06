import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 거울 설치 2151
public class Test {
    static int n;
    static char[][] arr;
    static ArrayList<door> doors = new ArrayList<>();
    static int[][] path;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        path = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == '#') {
                    doors.add(new door(i, j));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = Integer.MAX_VALUE;
            }
        }


        dijkstra(doors.get(0).row, doors.get(0).col);

    }
    static class door {
        int row, col;
        door(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return "row : " + row + ", col : " + col;
        }
    }
    static class q1 {
        int r, c, dir, w;
        q1(int r, int c, int dir, int w) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.w = w;
        }
        @Override
        public String toString() {
            return "r : " + r + ", c : " + c + ", dir : " + dir;
        }
    }
    static void dijkstra(int row, int col) {
        path[row][col] = 0;
        PriorityQueue<q1> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
        q.offer(new q1(row, col, 0, 100));
        q.offer(new q1(1, 2, 3, 4));
        System.out.println(q);
        while (!q.isEmpty()) {
            q1 cur = q.poll();

            if (path[cur.r][cur.c] < cur.w) {
                continue;
            }

            // 현재 위치가 !이면
            if (arr[cur.r][cur.c] == '!') {
                for (int dij = 0; dij < 4; dij++) {
                    int newRow = cur.r + di[dij];
                    int newCol = cur.c + dj[dij];

                    if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                        continue;
                    }

                    if (arr[newRow][newCol] == '*') {
                        continue;
                    }

                    // 같은 방향 -> 거울 설치 X
                    if ((dij + cur.dir) % 2 == 0) {
                        if (path[newRow][newCol] < cur.w) {
                            continue;
                        }
                        q.offer(new q1(newRow, newCol, dij, cur.w));
                        path[newRow][newCol] = cur.w;
                    }
                    // 다른 방향 -> 거울 설치
                    else {
                        if (path[newRow][newCol] < cur.w + 1) {
                            continue;
                        }
                        q.offer(new q1(newRow, newCol, dij, cur.w + 1));
                        path[newRow][newCol] = cur.w + 1;
                    }
                }
            }
            // 현재 위치가 .이면
            else if (arr[cur.r][cur.c] == '.') {
                int newRow = cur.r + di[cur.dir];
                int newCol = cur.c + dj[cur.dir];

                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                    continue;
                }

                if (arr[newRow][newCol] == '*') {
                    continue;
                }

                // 같은 방향 -> 거울 설치 X
                if (path[newRow][newCol] < cur.w) {
                    continue;
                }
                q.offer(new q1(newRow, newCol, cur.dir, cur.w));
                path[newRow][newCol] = cur.w;
            }

        }

    }
}