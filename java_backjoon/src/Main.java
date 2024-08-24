import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int mod = 1_000_000_007;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        tree = new int[4 * n];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, n, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {  // Update
                int oldC = arr[b];
                arr[b] = c;
                if (oldC == 0) {
                    init(1, n, 1);
                } else {
                    update(1, n, 1, b, c, oldC);
                }
            } else if (a == 2) {  // Query
                sb.append(query(1, n, 1, b, c)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1) % mod;
    }

    static int query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) * query(mid + 1, end, node * 2 + 1, left, right) % mod;
    }

    static void update(int start, int end, int node, int index, int newC, int oldC) {
        if (index < start || index > end) {
            return;
        }

        tree[node] = (tree[node] / oldC * newC) % mod;

        if (start != end) {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, index, newC, oldC);
            update(mid + 1, end, node * 2 + 1, index, newC, oldC);
        }
    }
}
