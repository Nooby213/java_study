package Silver;

import java.util.*;
import java.io.*;

public class Silver_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 1) + 1);
            max = Math.max(map.get(book), max);
        }
        List<String> bs = new LinkedList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                bs.add(key);
            }
        }
        Collections.sort(bs);
        System.out.println(bs.get(0));
    }
}


