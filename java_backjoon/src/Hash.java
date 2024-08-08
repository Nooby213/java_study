import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hash {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        char[] a = new char[]{1, 2, 3, 4};
        char[] b = new char[]{1, 2, 3, 4};
        String aa = String.valueOf(a);
        String bb = String.valueOf(b);
        map.put(aa, 1);
        System.out.println(map.get(bb));
        System.out.println(aa.equals(bb));
        System.out.println(aa == bb);
//        System.out.println(a.equals(b));
//        System.out.println(Arrays.equals(a, b));
//        System.out.println(a == b);


/*
    Java의 HashMap은 키로 사용되는 객체의 hashCode()와 equals() 메서드를 사용하여 키를 비교하고 해시 테이블에 저장된 항목을 검색합니다.
    이를 통해 HashMap은 동일한 내용을 가진 문자열이 다른 객체로 생성되더라도 올바르게 작동할 수 있습니다.

    hashCode() 메서드:
    hashCode() 메서드는 객체의 해시 코드를 반환합니다. HashMap은 이 해시 코드를 사용하여 객체를 버킷(bucket)에 할당합니다.
    String 클래스는 hashCode() 메서드를 오버라이드하여 문자열의 내용을 기반으로 해시 코드를 계산합니다.
    따라서 동일한 내용을 가진 문자열은 동일한 해시 코드를 갖습니다.

    equals() 메서드:
    HashMap은 같은 해시 코드를 가진 객체가 여러 개 있을 수 있으므로, equals() 메서드를 사용하여 실제로 동일한지를 확인합니다.
    String 클래스는 equals() 메서드를 오버라이드하여 문자열의 내용을 비교합니다.
    따라서 동일한 내용을 가진 문자열은 equals() 메서드를 사용하면 true를 반환합니다.
    이를 통해, HashMap은 동일한 내용을 가진 다른 String 객체를 키로 사용하더라도 이를 동일한 키로 인식할 수 있습니다.
*/
    }
}