package gold;

import java.util.*;
import java.io.*;

public class Gold_2933 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int R,C,N,H;
    static char[][] map;

    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0 ; i < R ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            int height = Integer.parseInt(st.nextToken());

            solve(R - height, i);
            bfs();
        }

        print();
    }


    private static void solve(int row, int i) {
        if(i % 2 == 0) {
            for(int j = 0 ; j < C ; j++) {
                if(map[row][j] == 'x') {
                    map[row][j] = '.';
                    break;
                }
            }
        }
        else {
            for(int j = C - 1 ; j >= 0 ; j--) {
                if(map[row][j] == 'x') {
                    map[row][j] = '.';
                    break;
                }
            }
        }
    }

    private static void bfs() {
        visited = new boolean[R][C];

        for(int j = 0 ; j < C ; j++) {
            if(map[R - 1][j] == '.' || visited[R - 1][j])   continue;

            visited[R - 1][j] = true;
            q.add(new int[]{R - 1, j});

            while(!q.isEmpty()) {
                int[] now = q.poll();

                for(int d = 0 ; d < 4 ; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];

                    if(!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] == '.') continue;

                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        List<int[]> cluster = new ArrayList<>();

        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(!visited[i][j] && map[i][j] == 'x') {
                    map[i][j] = '.';
                    cluster.add(new int[] {i, j});
                }
            }
        }

        if(cluster.isEmpty())   return;

        boolean down = true;
        while(down) {
            for(int[] now : cluster) {
                int nx = now[0] + 1;
                int ny = now[1];

                if(!inRange(nx, ny) || map[nx][ny] == 'x') {
                    down = false;
                    break;
                }
            }

            if(down) {
                for(int[] now : cluster) {
                    now[0]++;
                }
            }
        }


        for(int[] now : cluster) {
            map[now[0]][now[1]] = 'x';
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(char[] c : map) {
            for(char h : c) {
                sb.append(h);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

