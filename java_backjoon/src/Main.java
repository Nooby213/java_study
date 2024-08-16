import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        int strSize = str.length;
        int bombSize = bomb.length;
        char lastBomb = bomb[bombSize - 1];

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < strSize; i++) {
            char temp = str[i];
            stack.push(temp);

            if (temp == lastBomb) {
                boolean isBomb = true;
                int stackSize = stack.size();
                if (stackSize >= bombSize) {
                    for (int j = 0; j < bombSize; j++) {
                        if (stack.get(stackSize - bombSize + j) != bomb[j]) {
                            isBomb = false;
                            break;
                        }
                    }
                    if (isBomb) {
                        for (int j = 0; j < bombSize; j++) {
                            stack.pop();
                        }
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
