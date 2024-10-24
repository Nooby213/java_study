import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            long gifticon = Long.parseLong(st1.nextToken());
            long expire = Long.parseLong(st2.nextToken());
            if (expire > gifticon) {
                cnt += (expire - gifticon) / 30 + 1;
            }
        }
        System.out.println(cnt);
    }
}
