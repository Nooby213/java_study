package Silver;
import java.util.*;
import java.io.*;

public class Silver_10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plus = new int[10000001];
        int[] minus = new int[10000001];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp >= 0) {
                plus[temp] = 1;
            } else {
                minus[-temp] = 1;
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp >= 0) {
                if (plus[temp] == 1) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            } else {
                if (minus[-temp] == 1) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
        }
    }
}
