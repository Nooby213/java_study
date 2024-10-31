import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int cnt;
    static List<int[]> virus = new ArrayList<>();
    static int[][] room;
    static int size;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 2) {
                    virus.add(new int[]{i, j});
                    size++;
                }
            }
        }
    }
    static void build(int )
    static void spread() {
        boolean[][] visited = new boolean[n][m];
        int cnt = size;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < size; i++) {
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
                    cnt++;
                }
            }
        }
    }

    static boolean range(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
