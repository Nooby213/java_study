package gold;

import java.util.*;

public class Gold_13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[n] = 0;

        Deque<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.pollFirst();

            // 동생 찾으면 값 출력 후 리턴
            if (now == k) {
                System.out.println(arr[now]);
                return;
            }

            if (now - 1 >= 0 && arr[now - 1] > arr[now] + 1) {
                arr[now - 1] = arr[now] + 1;
                q.addLast(now - 1);
            }

            if (now + 1 < 100001 && arr[now + 1] > arr[now] + 1) {
                arr[now + 1] = arr[now] + 1;
                q.addLast(now + 1);
            }

            if (now * 2 < 100001 && arr[now * 2] > arr[now]) {
                arr[now * 2] = arr[now];
                q.addFirst(now * 2);
            }
        }
    }
}

