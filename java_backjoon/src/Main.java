import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static List<List<List<Integer>>> fish;
    static int shark = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        fish = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            fish.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if (temp != 0 && temp != 9) {
                    fish.get(temp).add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        System.out.println(fish);

        while (true) {
            int dis = Integer.MAX_VALUE;
            for (int i = 0; i < ; i++) {
                
            }
        }

    }
}
