import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bronze_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        StringBuffer sb = new StringBuffer(a);
        a = sb.reverse().toString();
        sb = new StringBuffer(b);
        b = sb.reverse().toString();
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        int result = (num1 > num2) ? num1 : num2;
        System.out.println(result);
    }
}
