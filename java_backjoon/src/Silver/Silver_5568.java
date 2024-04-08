package Silver;

import java.util.*;
import java.io.*;

public class Silver_5568 {
    static int n;
    static int k;
    static Set<String> permutations;
    static String[] cards;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new String[n];
        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }
        visited = new boolean[n];
        permutations = new HashSet<>();
        makePermutation("", 0);
        System.out.println(permutations.size());
    }

    static void makePermutation(String temp, int cnt) {
        if (cnt == k) {
            permutations.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makePermutation(temp + cards[i], cnt + 1);
                visited[i] = false;
            }
        }
    }
}