package gold;
import java.util.*;
import java.io.*;

public class Gold_20056 {
    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Fireball> fireballs = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        for (int k = 0; k < K; k++) {
            List<Fireball>[][] map = new ArrayList[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }

            for (Fireball fb : fireballs) {
                int nr = (fb.r + dr[fb.d] * fb.s % N + N) % N;
                int nc = (fb.c + dc[fb.d] * fb.s % N + N) % N;
                map[nr][nc].add(new Fireball(nr, nc, fb.m, fb.s, fb.d));
            }

            fireballs = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].size() == 1) {
                        fireballs.add(map[i][j].get(0));
                    } else if (map[i][j].size() > 1) {
                        int sumM = 0, sumS = 0, count = map[i][j].size();
                        boolean allEven = true;
                        boolean allOdd = true;
                        for (Fireball fb : map[i][j]) {
                            sumM += fb.m;
                            sumS += fb.s;
                            if (fb.d % 2 == 0) allOdd = false;
                            else allEven = false;
                        }
                        int newM = sumM / 5;
                        if (newM > 0) {
                            int newS = sumS / count;
                            int[] newDirs = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                            for (int newD : newDirs) {
                                fireballs.add(new Fireball(i, j, newM, newS, newD));
                            }
                        }
                    }
                }
            }
        }

        int totalMass = fireballs.stream().mapToInt(fb -> fb.m).sum();
        System.out.println(totalMass);
    }
}
