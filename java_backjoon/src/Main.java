import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
<<<<<<< HEAD
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        int len = 0;
        arr.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            int before = arr.get(len);
            if (before < now) {
                arr.add(now);
                len++;
            } else {
                binary(arr, len, now);
            }
        }
        System.out.println(len + 1);
    }

    static void binary(List<Integer> arr, int len, int now) {
        int start = 0;
        int end = len;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr.get(mid) < now) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        arr.set(end, now);
=======
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
>>>>>>> 76699622f9b260183f479a58d6b07ea95a5e4a04
    }
}