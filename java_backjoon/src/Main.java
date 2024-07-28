import java.awt.image.VolatileImage;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<List<List<Fireball>>> fireballs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            fireballs.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                fireballs.get(i).add(new LinkedList<>());
            }
        }
        System.out.println(fireballs);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int me = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.get(r-1).get(c-1).add(new Fireball(me, s, d));
        }

        for (int i = 0; i < k; i++) {

        }
        System.out.println(fireballs);
    }

    static class Fireball {
        int measure;
        int vel;
        int dir;
        public Fireball(int measure, int vel, int dir) {
            this.measure = measure;
            this.vel = vel;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return measure + " " + vel + " " + dir;
        }
    }

    static void sumFireball(List<Fireball> fbs, int y, int x) {
        int sum = 0;
        int v = 0;
        boolean sameD = true;
        int d = fbs.get(0).dir % 2;
        for (int i = 0; i < fbs.size(); i++) {
            Fireball temp = fbs.get(i);
            sum += temp.measure;
            v += temp.vel;
            if (d != temp.dir % 2) {
                sameD = false;
            }
        }
        if (sum >= 5) {

        }
    }
}

