package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold_1826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] stations = new int[1_000_001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int station = Integer.parseInt(st.nextToken());
            int oil = Integer.parseInt(st.nextToken());
            stations[station] = oil;
        }
        st = new StringTokenizer(br.readLine());
        int town = Integer.parseInt(st.nextToken());
        int oil = Integer.parseInt(st.nextToken());
        int cnt = 0;
        PriorityQueue<Integer> gas = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i <= town; i++) {
            oil--; // 연료 사용
            // 도착했으면 cnt반환
            if (i == town) {
                System.out.println(cnt);
                return;
            }
            // 주유소면 일단 킵
            if (stations[i] != 0) {
                gas.add(stations[i]);
            }
            // 가스 없으면
            if (oil < 0) {
                // 충전 못하면 끝
                if (gas.isEmpty()) {
                    System.out.println(-1);
                    return;
                } else {
                    oil += gas.poll();
                    cnt++;
                }
            }
        }
    }

}
