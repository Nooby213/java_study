package gold;

import java.io.*;
import java.util.*;

public class Gold_3425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            List<String> command = new ArrayList<>();
            String line;
            while (!(line = br.readLine()).equals("END")) {
                if (line.equals("QUIT")) {
                    System.out.print(sb);
                    return;
                }
                command.add(line);
            }

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                long[] stack = new long[1000];
                int size = 0;
                long num = Long.parseLong(br.readLine());
                stack[size++] = num;
                boolean error = false;

                for (String cmd : command) {
                    String[] parts = cmd.split(" ");
//                    for (long l : stack) {
//                        if (l != 0) System.out.print(l + ",");
//                    }
                    switch (parts[0]) {
                        case "NUM":
                            stack[size++] = Long.parseLong(parts[1]);
                            break;
                        case "POP":
                            if (size == 0) error = true;
                            else size--;
                            break;
                        case "INV":
                            if (size == 0) error = true;
                            else stack[size - 1] = -stack[size - 1];
                            break;
                        case "DUP":
                            if (size == 0) error = true;
                            else stack[size++] = stack[size - 2];
                            break;
                        case "SWP":
                            if (size < 2) error = true;
                            else {
                                long temp = stack[size - 1];
                                stack[size - 1] = stack[size - 2];
                                stack[size - 2] = temp;
                            }
                            break;
                        case "ADD":
                            if (size < 2) error = true;
                            else {
                                stack[size - 2] = stack[size - 2] + stack[size - 1];
                                size--;
                            }
                            break;
                        case "SUB":
                            if (size < 2) error = true;
                            else {
                                stack[size - 2] = stack[size - 2] - stack[size - 1];
                                size--;
                            }
                            break;
                        case "MUL":
                            if (size < 2) error = true;
                            else {
                                stack[size - 2] = stack[size - 2] * stack[size - 1];
                                size--;
                            }
                            break;
                        case "DIV":
                            if (size < 2) error = true;
                            else {
                                long a = stack[size - 1];
                                long b = stack[size - 2];
                                if (a == 0) error = true;
                                else {
                                    stack[size - 2] = b / a;
                                    size--;
                                }
                            }
                            break;
                        case "MOD":
                            if (size < 2) error = true;
                            else {
                                long a = stack[size - 1];
                                long b = stack[size - 2];
                                if (a == 0) error = true;
                                else {
                                    stack[size - 2] = b % a;
                                    size--;
                                }
                            }
                            break;
                    }
                    if (error) break;
                }
                if (error || size != 1 || Math.abs(stack[0]) > 1e9) {
                    sb.append("ERROR\n");
                } else {
                    sb.append(stack[0]).append("\n");
                }
            }
            sb.append("\n");
            br.readLine();
        }
    }
}
