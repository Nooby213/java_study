package Silver;

import java.io.*;
import java.util.*;

public class Silver_1446 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] distance = new int[d + 1];
        List<int[]> shortCut = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            // 끝 지점보다 멀거나 지름길 아니면 추가할 필요없음
            if (end > d || dis > (end - start)) {
                continue;
            }
            // 지름길이면 추가
            shortCut.add(new int[]{start, end, dis});
        }

        shortCut.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        int idx = 0;
        for (int move = 0; move <= d; move++) {
            if (move > 0) {
                distance[move] = Math.min(distance[move], distance[move - 1] + 1);
            }
            while (idx < shortCut.size() && shortCut.get(idx)[0] == move) {
                int[] now = shortCut.get(idx);
                distance[now[1]] = Math.min(distance[now[1]], distance[move] + now[2]);
                idx++;
            }
        }

        System.out.println(distance[d]);
    }
}
