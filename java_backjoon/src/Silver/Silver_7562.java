package Silver;

import java.util.*;
import java.io.*;

public class Silver_7562 {
    static int[][] board;
    static int[] start;
    static int[] goal;
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            start = new int[2];
            goal = new int[2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());
            board[start[0]][start[1]] = 1;

            if (start[0] == goal[0] && start[1] == goal[1]) {
                sb.append(0).append("\n");
                continue;
            }
            move();
        }
        System.out.println(sb);
    }

    static void move() {
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

        Deque<int[]> deque = new ArrayDeque<>();
        deque.push(new int[]{start[0], start[1], 0});

        while (!deque.isEmpty()) {
            int[] now = deque.poll();

            for (int i = 0; i < 8; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 0) {
                    if (ny == goal[0] && nx == goal[1]) {
                        sb.append(now[2] + 1).append("\n");
                        return;
                    }
                    board[ny][nx] = 1;
                    deque.add(new int[]{ny, nx, now[2] + 1});
                }
            }
        }
    }
}
