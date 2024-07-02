package Silver;
import java.io.*;
import java.util.*;

public class Sliver_1920 {
    static List<Integer> arr;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> findArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            findArr.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            binary(findArr.get(i));
        }
        System.out.println(sb);
    }

    static void binary(int num) {
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr.get(mid) > num) {
                e = mid - 1;
            } else if (arr.get(mid) < num) {
                s = mid + 1;
            } else {
                sb.append(1).append("\n");
                return;
            }
        }
        sb.append(0).append("\n");
    }
}