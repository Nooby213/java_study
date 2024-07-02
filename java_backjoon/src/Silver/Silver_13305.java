package Silver;
import java.io.*;
import java.util.*;

public class Silver_13305 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] distance = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long mini = 0L;
        long minCost = 1_000_000_001L;

        for (int i = 0; i < n; i++) {
            long cost = Integer.parseInt(st.nextToken());
            minCost = Math.min(minCost, cost);
            mini += minCost * distance[i];
        }
        System.out.println(mini);
    }
}