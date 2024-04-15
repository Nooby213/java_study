import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // 파일의 끝까지 입력을 받음
        while (br.ready()) {
            // 입력 처리
            System.out.println("입력: " + br.readLine());
        }

        br.close(); // 입력 스트림 닫기
    }
}
