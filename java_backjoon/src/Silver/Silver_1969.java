package Silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] dnas = new String[n];
        for (int i = 0; i < n; i++) {
            dnas[i] = br.readLine();
        }
        String s = "";
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int[] cnts = new int[4];
            for (int j = 0; j < n; j++) {
                char nucleotide = dnas[j].charAt(i);
                if (nucleotide == 'A') {
                    cnts[0]++;
                } else if (nucleotide == 'C') {
                    cnts[1]++;
                } else if (nucleotide == 'G') {
                    cnts[2]++;
                } else if (nucleotide == 'T') {
                    cnts[3]++;
                }
            }
            int mini = 0;
            for (int k = 1; k < 4; k++) {
                if (cnts[k] > cnts[mini]) {
                    mini = k;
                }
            }
            if (mini == 0) {
                s += 'A';
            } else if (mini == 1) {
                s += 'C';
            } else if (mini == 2) {
                s += 'G';
            } else if (mini == 3) {
                s += 'T';
            }
            cnt += n - cnts[mini];
        }
        System.out.println(s);
        System.out.println(cnt);
    }
}
