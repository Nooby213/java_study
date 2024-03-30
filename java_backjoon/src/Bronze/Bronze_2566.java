package Bronze;

import java.util.*;
import java.io.*;

public class Bronze_2566 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = -1;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp > max) {
                    max = temp;
                    maxX = j + 1;
                    maxY = i + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(maxY + " " + maxX);
    }
}

