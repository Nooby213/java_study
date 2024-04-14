package Silver;
import java.util.*;
import java.io.*;

public class Silver_14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> setS = new HashSet<>();

        for (int i = 0; i < n; i++) {
            setS.add(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (setS.contains(str)) {
                count++;
            }
        }

        System.out.println(count);
    }
}