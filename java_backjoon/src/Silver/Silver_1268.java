package Silver;
import java.util.*;
import java.io.*;

public class Silver_1268 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] classes = new int[n][5];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;
        int president = 1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    for (int k = 0; k < 5; k++) {
                        if (classes[i][k] == classes[j][k]) {
                            count++;
                            break;
                        }
                    }
                }
            }
            if (count > maxCount) {
                maxCount = count;
                president = i + 1;
            }
        }

        System.out.println(president);

    }
}
