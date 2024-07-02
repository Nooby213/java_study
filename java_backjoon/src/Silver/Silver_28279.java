package Silver;

import java.io.*;
import java.util.*;

public class Silver_28279 {
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());


        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (order == 2) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (order == 3) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            } else if (order == 4) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            } else if (order == 5) {
                sb.append(deque.size()).append("\n");
            } else if (order == 6) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (order == 7) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            } else {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }

        br.close();
        // 백준 문제같이 프로세스 단위로 실행되는 코드는 상관없지만
        // close 메소드의 진짜 목적은 OS자원을 다시 되돌리는 것이라
        // System.in 대신에  파일을 읽게 만든다든지, 네트워크에서 어떤 것을 읽게 될 경우 OS에서 관리하기 때문에
        // close 해주지 않으면 다음 작업이 진행이 되지 않는다
        System.out.println(sb);
    }
}