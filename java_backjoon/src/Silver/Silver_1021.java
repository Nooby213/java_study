package Silver;
import java.io.*;
import java.util.*;

public class Silver_1021 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cost = 0;
        int idx = 0;
        List<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            int tempIdx = arr.indexOf(find);
            arr.remove(tempIdx);
            int lowCost = Math.min(Math.abs(idx - tempIdx), n - Math.abs(idx - tempIdx));
            cost += lowCost;
            n--;
            if (tempIdx > n) {
                idx = 0;
            } else {
                idx = tempIdx;
            }
        }
        System.out.println(cost);
    }
}