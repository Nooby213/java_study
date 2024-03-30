package Bronze;

import java.util.*;
import java.io.*;

public class Bronze_2745 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int jin = Integer.parseInt(sc.next());
        int len = number.length();
        double result = 0;
        for (int i = 0; i < len; i++) {
            int temp = number.charAt(i);
            if (temp >= 65) {
                result += Math.pow(jin, len - i - 1) * (temp - 55);
            } else {
                result += Math.pow(jin, len - i - 1) * (temp - '0');
            }
        }
        System.out.println((int)result);
    }
}
