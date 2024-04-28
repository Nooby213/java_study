package Silver;
import java.util.*;
import java.io.*;

public class Silver_1912 {
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int max = numbers[0];
        for (int i = 1; i < n; i++) {
            numbers[i] = Math.max(numbers[i], numbers[i] + numbers[i - 1]);
            max = Math.max(numbers[i], max);
        }
        System.out.println(max);
    }
}
