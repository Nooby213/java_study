import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception{
        List<Node> arr = new ArrayList<>();
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        node2.compareTo(node1);
    }

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}

