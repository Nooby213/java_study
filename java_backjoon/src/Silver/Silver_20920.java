package Silver;
import java.util.*;
import java.io.*;

public class Silver_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            if (word.length() >= M) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCount.entrySet());
        entryList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                if (a.getKey().length() == b.getKey().length()) {
                    return a.getKey().compareTo(b.getKey());
                }
                return Integer.compare(b.getKey().length(), a.getKey().length());
            }
            return Integer.compare(b.getValue(), a.getValue());
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey());
        }
    }
}
