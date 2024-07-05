package gold;

import java.util.*;
import java.io.*;

public class Gold_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            board[row][col] = 'a';
        }

        int[] direction = new int[10001];
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            if (d == 'L') {
                direction[t] = 3;
            } else {
                direction[t] = 1;
            }
        }
        int col = 0;
        int row = 0;
        int time = 0;
        int dir = 0;    // 0 : r, 1 : d, 2 : l, 3 : u
        int[] tail = new int[]{0, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};
        List<Integer> snake = new ArrayList<>();
        snake.add(0);
        board[0][0] = 's';
        while (true) {
            // 방향 변경
            dir = (dir + direction[time]) % 4;
            if (dir == 0) {
                col++;
            } else if (dir == 1) {
                row++;
            } else if (dir == 2) {
                col--;
            } else if (dir == 3) {
                row--;
            }
            // 벽에 박으면
            if (col < 0 || col >= n || row < 0 || row >= n) {
                break;
            }
            // 뱀 몸끼리 닿으면
            if (board[row][col] == 's') {
                break;
            }
            // 사과면
            if (board[row][col] == 'a') {
                board[row][col] = 's';
                snake.addFirst(dir);
            } else { // 아니면
                board[tail[0]][tail[1]] = 0;
                for (int i = snake.size() - 1; i >= 1; i--) {
                    snake.set(i, snake.get(i - 1));
                }
                snake.set(0, dir);
                tail[0] += dy[snake.getLast()];
                tail[1] += dx[snake.getLast()];
                board[row][col] = 's';
            }
            time++;
        }
        // 0초부터 시작해서
        System.out.println(time + 1);
    }
}

