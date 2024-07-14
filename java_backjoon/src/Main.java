import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<long[]> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long[] temp = new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())};
            lines.add(temp);
        }

        lines.sort(Comparator.comparing((long[] a) -> a[0]).thenComparing(a -> a[1]));

        long start = lines.get(0)[0];
        long end = lines.get(0)[1];
        long sum = 0;

        for (int i = 1; i < n; i++) {
            long nowStart = lines.get(i)[0];
            long nowEnd = lines.get(i)[1];

            if (nowStart <= end) {
                // 겹치거나 붙어 있을 때
                end = Math.max(end, nowEnd);
            } else {
                // 겹치지 않을 때
                sum += end - start;
                start = nowStart;
                end = nowEnd;
            }
        }

        sum += end - start;

        System.out.println(sum);

    }
}
