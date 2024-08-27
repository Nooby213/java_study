import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] weight = new boolean[n * 500 + 1];
        List<Integer> choo = new ArrayList<>();
        int[] visited = new int[501];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int w = Integer.parseInt(st.nextToken());
            visited[w]++;
            choo.add(w * visited[w]);
        }
        System.out.println(choo);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
    }
}