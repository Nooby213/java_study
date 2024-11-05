import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Station {
        int dis;
        int oil;

        public Station(int dis, int oil) {
            this.dis = dis;
            this.oil = oil;
        }

        @Override
        public String toString() {
            return "Station{" +
                    "dis=" + dis +
                    ", oil=" + oil +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Station> stations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dis = Integer.parseInt(st.nextToken());
            int oil = Integer.parseInt(st.nextToken());
            stations.add(new Station(dis, oil));
        }
        Collections.sort(stations, ((o1, o2) -> o1.dis - o2.dis));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int town = Integer.parseInt(st.nextToken());
        int oil = Integer.parseInt(st.nextToken());
        stations.add(new Station(town, 0));

        int pre = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Station cur = stations.get(i);
            Station nxt = stations.get(i + 1);
            oil -= cur.dis - pre;
            if (nxt.dis == town) {
                if (nxt.dis - cur.dis >= oil) {
                    System.out.println(cnt);
                    return;
                } else {
                    System.out.println(-1);
                    return;
                }
            }

            if (oil - cur.dis < 0) {
                System.out.println(-1);
                return;
            } else if (oil < nxt.dis - cur.dis) {
                cnt++;
                oil += cur.oil;
            }
            pre = cur.dis;
            oil--;
        }


    }

}
