import java.util.Comparator;
import java.util.TreeSet;

public class Test {
    public static void main (String[] args) {
        TreeSet<Integer> treeSet1 = new TreeSet<>((o1, o2) -> o1 - o2);
        TreeSet<Integer> treeSet2 = new TreeSet<>((o1, o2) -> o2 - o1);
        TreeSet<Node> treeSet3 = new TreeSet<>(Comparator.comparing(n -> n.b));
        for (int i = 0; i < 10; i++) {
            treeSet1.add(i);
            treeSet2.add(i);
        }
        System.out.println(treeSet1);
        System.out.println(treeSet2);

        treeSet3.add(new Node("200", 999));
        for (int i = 0; i < 10; i++) {
            treeSet3.add(new Node(String.valueOf(i), i+100));
        }

        System.out.println(treeSet3);
    }
    static class Node {
        String a;
        int b;

        public Node(String a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + ", " + b;
        }
    }
}
