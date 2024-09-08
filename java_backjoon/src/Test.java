import java.util.*;
import java.io.*;

public class Test {
    static char[][] map = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String row = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        comb(0, 0, 0, 0);
        System.out.println(answer);
    }

    public static void comb(int cnt, int yCnt, int startY, int startX) {
        if (cnt == 7) {
            if (yCnt < 4 && check()) {
                answer++;
            }
            return;
        }

        for (int i = startY; i < 5; i++) {
            for (int j = (i == startY ? startX : 0); j < 5; j++) {
                visited[i][j] = true;
                comb(cnt + 1, yCnt + (map[i][j] == 'Y' ? 1 : 0), i, j + 1);
                visited[i][j] = false;
            }
        }
    }

    public static boolean check() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] checkVisited = new boolean[5][5];

        outerLoop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    q.add(new int[]{i, j});
                    checkVisited[i][j] = true;
                    break outerLoop;
                }
            }
        }

        int cnt = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] now = q.poll();
            cnt++;
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    if (visited[nx][ny] && !checkVisited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        checkVisited[nx][ny] = true;
                    }
                }
            }
        }

        return cnt == 7;
    }
}
