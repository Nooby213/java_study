package Silver;

import java.util.*;
import java.io.*;

public class Silver_25206 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> scoreBoard = new HashMap<>(9);
        scoreBoard.put("A+",4.5);
        scoreBoard.put("A0",4.0);
        scoreBoard.put("B+",3.5);
        scoreBoard.put("B0",3.0);
        scoreBoard.put("C+",2.5);
        scoreBoard.put("C0",2.0);
        scoreBoard.put("D+",1.5);
        scoreBoard.put("D0",1.0);
        scoreBoard.put("F",0.0);
        double sum = 0;
        double cnt = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double grade = Double.parseDouble(st.nextToken());
            String code = st.nextToken();
            // P 라면 더하지 않는다.
            if (code.equals("P")) {
                continue;
            }
            double score =  scoreBoard.get(code);
            sum += (grade * score);
            cnt += grade;
        }
        System.out.printf("%.6f", sum/cnt);
    }
}