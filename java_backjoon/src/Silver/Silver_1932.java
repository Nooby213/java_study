package Silver;
import java.util.*;
import java.io.*;

public class Silver_1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<int[]> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] temp = new int[i + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            triangle.add(temp);
        }
        List<int[]> score = new ArrayList<>(triangle);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    score.get(i)[j] = score.get(i - 1)[j] + triangle.get(i)[j];
                } else if (j == i) {
                    score.get(i)[j] = score.get(i - 1)[j - 1] + triangle.get(i)[j];
                } else {
                    score.get(i)[j] = Math.max(score.get(i - 1)[j], score.get(i - 1)[j - 1]) + triangle.get(i)[j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(score.get(n - 1)[i], max);
        }
        System.out.println(max);
    }
}
