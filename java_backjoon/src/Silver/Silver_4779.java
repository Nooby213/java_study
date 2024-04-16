package Silver;
import java.util.*;
import java.io.*;

public class Silver_4779 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String str;
        List<String> result;
        while ((str = br.readLine()) != null) {
            n = Integer.parseInt(str);
            sb = new StringBuilder();
            for (int j = 0; j < Math.pow(3, n); j++) {
                sb.append("-");
            }
            cantor(0, sb.length());
            System.out.println(sb);
        }
    }

    static void cantor(int start, int size) {
        if (size == 1) {
            return;
        }
        int newSize = size / 3;
        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            sb.setCharAt(i, ' ');
        }
        cantor(start, newSize);
        cantor(start + 2 * newSize, newSize);
    }
}



