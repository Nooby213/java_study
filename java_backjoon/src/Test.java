import java.util.*;

public class Test {
    public static void main (String[] args) {
        // UUID 생성 후 숫자로 변환
        String uuidNumeric = UUID.randomUUID().toString().replaceAll("[^0-9]", "");

        // 8자리 숫자 추출 (앞에서 8자리를 자르고, 4자리-4자리로 나누기)
        String aa = uuidNumeric.substring(0, 4) + "-" + uuidNumeric.substring(4, 8);
        System.out.println(aa);
    }
}
