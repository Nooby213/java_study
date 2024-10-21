import java.util.*;
import java.io.*;

public class Main {
    static int mod = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<List<Integer>> binomial = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            binomial.add(new ArrayList<>());
        }
        binomial.get(1).add(1);
        for (int i = 2; i <= n; i++) {
            binomial.get(i).add(1);
            if (i == 2) {
                binomial.get(i).add(1);
                continue;
            }
            for (int j = 1; j < i; j++) {
                binomial.get(i).add(binomial.get(i - 1).get(j - 1) + binomial.get(i - 1).get(j));
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(binomial.get(i));
        }
        System.out.println(binomial.get(n).get(k));
    }
}
