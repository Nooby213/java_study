package Silver;

import java.util.*;
import java.io.*;

public class Silver_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int cnt = 0;
        String input;

        while ((input = br.readLine()) != null) {
            cnt++;
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                list.add(input);
                map.put(input, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (String name : list) {
            sb.append(name)
                    .append(" ")
                    .append(String.format("%.4f", (double) map.get(name) / cnt * 100))
                    .append("\n");
        }

        System.out.print(sb);
    }
}

