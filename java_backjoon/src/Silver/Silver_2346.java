package Silver;

import java.util.*;
import java.io.*;

public class Silver_2346 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> balloons = new ArrayDeque<>();
        int n = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            balloons.add(new Balloon(n++, Integer.parseInt(st.nextToken())));
        }
        Balloon balloon = balloons.poll();
        System.out.print(balloon.idx + " ");
        while (!balloons.isEmpty()) {
            int num = balloon.num;
            if (num > 0) {
                for (int i = 0; i < num - 1; i++) {
                    balloons.addLast(balloons.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(num); i++) {
                    balloons.addFirst(balloons.pollLast());
                }
            }
            balloon = balloons.poll();
            System.out.print(balloon.idx + " ");
        }
    }
}

class Balloon {
    int idx;
    int num;

    public Balloon(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}
