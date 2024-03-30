import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Bronze_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split("");
        int time = 0;
        for (String w : words) {
            int temp = w.charAt(0);
            if (temp >= 'S'){
                if (temp == 'S'){
                    temp = 'P';
                } else if (temp == 'T' || temp == 'U' || temp == 'V'){
                    temp = 'T';
                } else {
                    temp = 'W';
                }
            }
            time += (temp - 'A') / 3 + 3;
        }
        System.out.println(time);
    }
}
