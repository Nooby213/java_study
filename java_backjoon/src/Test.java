import java.util.*;
import java.io.*;

public class Test {
    static int l;
    static int k;
    static int c;
    static int largest;
    static int largestIdx;
    static int[] cut;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        cut = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            cut[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cut);
        int min = 1;
        int max = l;
        while (min < max) {
            int mid = (min + max) / 2;

        }
    }

    static int cutting(int length) {
        int preCut = l; // 전에 자른 곳
        int minCut = 0; // 자른 곳 중에 제일 앞에
        int cutCnt = 0; // 자른 횟수
        for (int i = k - 1; i >= 0; i--) {
            // 자르는 부분이 최장 길이보다 길면
            if (preCut - cut[i] > length) {
                if (i == k - 1) return 0;
                preCut = cut[i + 1];
                if (preCut - cut[i] > length) return 0;
                cutCnt++;
                minCut = cut[i + 1];
            }
            if (cutCnt >= c) break;
        }
        if (cutCnt < c) {

        }

        return minCut;
    }
}