import java.util.*;
import java.io.*;

public class Test {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node("root");

        for (int i = 0; i < n; i++) {
            String[] tempDir = br.readLine().split("\\\\");
            Node now = root;

            for (String dir : tempDir) {
                now.children.putIfAbsent(dir, new Node(dir));
                now = now.children.get(dir);
            }
        }

        makeDir(root, 0);
        System.out.println(sb);
    }

    static class Node {
        String name;
        Map<String, Node> children = new TreeMap<>();

        public Node(String name) {
            this.name = name;
        }
    }

    static void makeDir(Node node, int d) {
        if (d > 1) {
            for (int i = 0; i < d - 1; i++) {
                sb.append(' ');
            }
        }
        if (d > 0) {
            sb.append(node.name).append('\n');
        }
        for (Node c : node.children.values()) {
            makeDir(c, d + 1);
        }
    }
}