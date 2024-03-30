import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] chess = {1, 1, 2, 2, 2, 8};
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < chess.length; i++) {
            int temp = chess[i] - Integer.parseInt(st.nextToken());
            chess[i] = temp;
        }
        for (int c : chess) {
            System.out.print(c + " ");
        }
    }
}

