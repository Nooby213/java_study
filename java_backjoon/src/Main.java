import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(":");
        System.out.println();
        int l = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int s = 1;
        int e = (l < r) ? l : r;
        int m = (s + e) / 2;
        while (s < e) {
            m = (s + e) / 2;

        }
    }
}
