package gold;

import java.util.*;
import java.io.*;

public class Gold_1956 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] visited = new int[v + 1][v + 1];
        for (int i = 0; i <= v; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            visited[i][i] = 0;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            visited[a][b] = c;

        }

        for (int mid = 1; mid <= v; mid++) {
            for (int start = 1; start <= v; start++) {
                for (int end = 1; end <= v; end++) {
                    if (visited[start][mid] != Integer.MAX_VALUE && visited[mid][end] != Integer.MAX_VALUE) {
                        visited[start][end] = Math.min(visited[start][end], visited[start][mid] + visited[mid][end]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int start = 1; start <= v; start++) {
            for (int end = 1; end <= v; end++) {
                if (start != end && visited[start][end] != Integer.MAX_VALUE && visited[end][start] != Integer.MAX_VALUE) {
                    min = Math.min(min, visited[start][end] + visited[end][start]);
                }
            }
        }
        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
    }
}


