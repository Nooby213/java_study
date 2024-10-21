package platinum;

import java.util.*;
import java.io.*;

public class Platinum_3197 {
    static int r;
    static int c;
    static char[][] lake;
    static boolean[][] visitedSwan;
    static boolean[][] visitedWater;
    static Queue<int[]> swanQueue;
    static Queue<int[]> waterQueue;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[] swan1, swan2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        lake = new char[r][c];
        visitedSwan = new boolean[r][c];
        visitedWater = new boolean[r][c];
        waterQueue = new LinkedList<>();
        swanQueue = new LinkedList<>();

        boolean firstSwanFound = false;

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                lake[i][j] = line.charAt(j);
                if (lake[i][j] == 'L') {
                    if (!firstSwanFound) {
                        swan1 = new int[]{i, j};
                        swanQueue.add(swan1);
                        visitedSwan[i][j] = true;
                        firstSwanFound = true;
                    } else {
                        swan2 = new int[]{i, j};
                    }
                }
                if (lake[i][j] == '.' || lake[i][j] == 'L') {
                    waterQueue.add(new int[]{i, j});
                    visitedWater[i][j] = true;
                }
            }
        }

        int days = 0;

        while (!canMeet()) {
            meltIce();
            days++;
        }

        System.out.println(days);
    }

    static void meltIce() {
        int size = waterQueue.size();
        for (int i = 0; i < size; i++) {
            int[] water = waterQueue.poll();
            for (int k = 0; k < 4; k++) {
                int ni = water[0] + di[k];
                int nj = water[1] + dj[k];
                if (range(ni, nj) && lake[ni][nj] == 'X') {
                    lake[ni][nj] = '.';
                    waterQueue.add(new int[]{ni, nj});
                    visitedWater[ni][nj] = true;
                }
            }
        }
    }

    static boolean canMeet() {
        Queue<int[]> nextQueue = new LinkedList<>();
        while (!swanQueue.isEmpty()) {
            int[] cur = swanQueue.poll();
            for (int k = 0; k < 4; k++) {
                int ni = cur[0] + di[k];
                int nj = cur[1] + dj[k];
                if (range(ni, nj) && !visitedSwan[ni][nj]) {
                    visitedSwan[ni][nj] = true;
                    if (lake[ni][nj] == 'L') {
                        return true;
                    }
                    if (lake[ni][nj] == '.') {
                        swanQueue.add(new int[]{ni, nj});
                    } else if (lake[ni][nj] == 'X') {
                        nextQueue.add(new int[]{ni, nj});
                    }
                }
            }
        }
        swanQueue = nextQueue;
        return false;
    }

    static boolean range(int i, int j) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}

