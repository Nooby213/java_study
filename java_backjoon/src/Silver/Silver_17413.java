package Silver;
import java.io.*;

public class Silver_17413 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        reverseWord(str);

        System.out.println(sb);
    }
    static void reverseWord(String temp) {
        StringBuilder tempSb = new StringBuilder();
        int i = 0;
        while (i < temp.length()) {
            if (temp.charAt(i) == '<') {
                sb.append(tempSb.reverse());
                tempSb = new StringBuilder();
                int idx = i;
                while (temp.charAt(idx) != '>') {
                    sb.append(temp.charAt(idx));
                    idx++;
                }
                sb.append(">");
                i = idx;
            } else if (temp.charAt(i) == ' ') {
                sb.append(tempSb.reverse()).append(" ");
                tempSb = new StringBuilder();
            } else {
                tempSb.append(temp.charAt(i));
            }
            i++;
        }
        sb.append(tempSb.reverse());
    }
}
