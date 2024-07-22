package gold;

import java.util.*;
import java.io.*;

public class Gold_16928 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        int[] ladder = new int[101];
        int[] snake = new int[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ladder[s] = e;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            snake[s] = e;
        }


        Deque<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int now = q.pollFirst();
            if (now == 100) {
                System.out.println(board[100]);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next <= 100 && board[next] == 0) {
                    if (ladder[next] != 0) {
                        next = ladder[next];
                    } else if (snake[next] != 0) {
                        next = snake[next];
                    }
                    if (board[next] == 0) {
                        board[next] = board[now] + 1;
                        q.add(next);
                    }
                }
            }
        }
    }
}

