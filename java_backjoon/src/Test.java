import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Gifticon> gifticons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long expire = Long.parseLong(st1.nextToken());
            long useDate = Long.parseLong(st2.nextToken());
            gifticons.add(new Gifticon(expire, useDate));
        }
        gifticons.sort(Comparator.comparingLong((Gifticon o) -> o.useDate).thenComparingLong(o -> o.expire));

        Gifticon first = gifticons.get(0);
        long min = 0;
        if (first.useDate > first.expire) {
            long cnt = (long) Math.ceil((first.useDate - first.expire) / 30.0);
            first.expire += 30 * cnt;
        }
        long maxExpire = first.expire;
        long preUseDate = first.useDate;

        for (int i = 1; i < n; i++) {
            Gifticon cur = gifticons.get(i);

            long cnt = 0;

            if (cur.expire < cur.useDate) {
                cnt = (long) Math.ceil((cur.useDate - cur.expire) / 30.0);
                cur.expire += 30 * cnt;
                min += cnt;
            }

            if (preUseDate > cur.expire) {
                if (preUseDate != cur.useDate) {
                    cnt = (long) Math.ceil((maxExpire - cur.expire) / 30.0);
                    cur.expire += 30 * cnt;
                    min += cnt;
                    preUseDate = Math.max(maxExpire, cur.expire);
                } else {
                    cnt = (long) Math.ceil((preUseDate - cur.expire) / 30.0);
                    cur.expire += 30 * cnt;
                    min += cnt;
                }
            }

            maxExpire = Math.max(maxExpire, cur.expire);

        }

        System.out.println(min);
    }

    static class Gifticon {
        long expire;
        long useDate;
        public Gifticon(long expire, long useDate) {
            this.expire = expire;
            this.useDate = useDate;
        }
    }
}
