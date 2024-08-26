package gold;

import java.util.*;
import java.io.*;

public class Gold_17144 {
    static int[][] map;
    static int r, c;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        int cleanR = -1;

        for(int i = 0; i< r; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j< c; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;

                if(a == -1 && cleanR == -1)
                    cleanR = i;
            }
        }

        while(t-->0){
            spread();
            move(cleanR);
        }

        int sum = 0;
        for(int i = 0; i< r; i++)
            for (int j = 0; j < c; j++)
                sum += map[i][j];

        System.out.println(sum+2);
    }

    static void spread(){
        List<Dust> l = new ArrayList<>();

        for(int i = 0; i< r; i++)
            for(int j = 0; j< c; j++)
                if(map[i][j]>=5)
                    l.add(new Dust(i, j, map[i][j]));

        for (Dust dust : l) {
            int count = 0;

            int nowR = dust.row;
            int nowC = dust.col;
            int nowV = dust.val;

            for (int j = 0; j < 4; j++) {
                int nextR = nowR + di[j];
                int nextC = nowC + dj[j];

                if (nextR < 0 || nextC < 0 || nextR >= r || nextC >= c)
                    continue;
                if (map[nextR][nextC] == -1)
                    continue;

                map[nextR][nextC] += nowV / 5;
                count++;
            }

            map[nowR][nowC] -= nowV / 5 * count;
        }
    }

    static void move(int cleanR) {
        moveUpper(cleanR);
        moveLower(cleanR + 1);
    }

    static void moveUpper(int cleanR) {
        for (int i = cleanR - 2; i >= 0; i--)
            map[i + 1][0] = map[i][0];
        for (int i = 0; i < c - 1; i++)
            map[0][i] = map[0][i + 1];
        for (int i = 0; i < cleanR; i++)
            map[i][c - 1] = map[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            map[cleanR][i] = map[cleanR][i - 1];
        map[cleanR][1] = 0;
    }

    static void moveLower(int cleanR) {
        for (int i = cleanR + 1; i < r - 1; i++)
            map[i][0] = map[i + 1][0];
        for (int i = 0; i < c - 1; i++)
            map[r - 1][i] = map[r - 1][i + 1];
        for (int i = r - 1; i > cleanR; i--)
            map[i][c - 1] = map[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            map[cleanR][i] = map[cleanR][i - 1];
        map[cleanR][1] = 0;
    }
}

class Dust {
    int row, col, val;

    Dust(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}