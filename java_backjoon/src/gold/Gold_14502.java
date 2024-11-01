package gold;

import java.io.*;
import java.util.*;

public class Gold_14502 {
    static int n;
    static int m;
    static int cnt;
    static List<int[]> virus = new ArrayList<>();
    static int[][] room;
    static int roomSize;
    static int wallCnt;
    static int virusCnt;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        roomSize = n * m;
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 2) {
                    virus.add(new int[]{i, j});
                    virusCnt++;
                } else if (room[i][j] == 1) {
                    wallCnt++;
                }
            }
        }
        wallCnt += 3;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == 0) {
                    room[i][j] = 1;
                    build(i, j, 1);
                    room[i][j] = 0;
                }
            }
        }
        System.out.println(cnt);
    }

    static void build(int i, int j, int cnt) {
        if (cnt == 3) {
            spread();
            return;
        }

        for (int k = i; k < n; k++) {
            for (int l = k == i ? j + 1 : 0; l < m; l++) {
                if (room[k][l] == 0) {
                    room[k][l] = 1;
                    build(k, l, cnt + 1);
                    room[k][l] = 0;
                }
            }
        }
    }

    static void spread() {
        boolean[][] visited = new boolean[n][m];
        int tempCnt = virusCnt;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < virusCnt; i++) {
            q.add(virus.get(i));
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ni = cur[0] + di[i];
                int nj = cur[1] + dj[i];
                if (range(ni, nj) && !visited[ni][nj] && room[ni][nj] == 0) {
                    visited[ni][nj] = true;
                    q.add(new int[]{ni, nj});
                    tempCnt++;
                }
            }
        }
        cnt = Math.max(cnt, roomSize - tempCnt - wallCnt);

    }

    static boolean range(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}

