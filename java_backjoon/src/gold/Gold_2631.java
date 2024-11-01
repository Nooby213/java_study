package gold;

import java.io.*;
import java.util.*;

public class Gold_2631 {
    static List<Integer> list;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(Integer.parseInt(br.readLine()));
        size = 1;
        for (int i = 1; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (list.get(size - 1) < cur) {
                list.add(cur);
                size++;
            } else {
                putNumber(cur);
            }
        }
        System.out.println(n - size);
    }

    static void putNumber(int cur) {
        int s = 0;
        int e = size - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (list.get(mid) > cur) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        list.set(e, cur);
    }
}

