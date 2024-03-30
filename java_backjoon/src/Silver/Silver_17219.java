import java.util.*;
import java.io.*;
public class Silver_17219 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> memos = new HashMap<String, String>(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String siteName = st.nextToken();
            String password = st.nextToken();
            memos.put(siteName, password);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            bw.write(memos.get(site) + "\n");
//            sb.append(memos.get(site) + "\n");
        }
        bw.close();
//        System.out.println(sb);
    }
}