import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            board[s] = 100 + e;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            board[e] = -(e - s);
        }
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (true) {
            int[] now = q.pollLast();
            int pos = now[0];
            int cnt = now[1];
            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next <= 100 && board[next] != 0) {

                }
            }
        }
    }
}
