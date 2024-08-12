import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Test {
    public static void main (String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            treeSet.add(i);
        }
        System.out.println(treeSet);
        treeSet.getLast();
    }
}
