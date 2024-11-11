package gold;

import java.util.*;
import java.io.*;

public class Gold_1114 {
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
        int cuttingPoint = 0;

        while (min < max) {
            int mid = (min + max) / 2;
            int res = cutting(mid);

            if (res > 0) {
                max = mid;
                cuttingPoint = res;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max + " " + cuttingPoint);
    }

    static int cutting(int length) {
        int preCut = l; // 전에 자른 곳
        int minCut = 0; // 자른 곳 중에 제일 앞에
        int cutCnt = 0; // 자른 횟수
        for (int i = k - 1; i >= 0; i--) {
            // 자르는 부분이 최장 길이보다 길면 잘라야됌
            if (preCut - cut[i] > length) {
                if (i == k - 1) return 0;
                // 자른다
                preCut = cut[i + 1];
                // 전에 자른부분과 지금이 길이보다 길면
                if (preCut - cut[i] > length) return 0;
                // 자른 횟수 + 1
                cutCnt++;
                // 자른 최소 지점 재할당
                minCut = cut[i + 1];
            }
            // 횟수 채웠으면 더 안자름
            if (cutCnt >= c) break;
        }
        // 덜 잘랐으면
        if (cutCnt < c) {
            minCut = cut[0];
        }
        // 최소가 길이보다 길면
        if (minCut > length) return 0;

        return minCut;
    }
}