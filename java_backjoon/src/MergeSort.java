import java.util.*;
import java.io.*;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> sortedArr = merge_sort(arr);
        System.out.println(sortedArr);
    }

    static List<Integer> merge_sort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int midIdx = arr.size() / 2;
        List<Integer> left = new ArrayList<>(arr.subList(0, midIdx));
        List<Integer> right = new ArrayList<>(arr.subList(midIdx, arr.size()));

        left = merge_sort(left);
        right = merge_sort(right);

        return merge(left, right);
    }

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIdx = 0;
        int rightIdx = 0;

        while (leftIdx < left.size() && rightIdx < right.size()) {
            if (left.get(leftIdx) <= right.get(rightIdx)) {
                merged.add(left.get(leftIdx));
                leftIdx++;
            } else {
                merged.add(right.get(rightIdx));
                rightIdx++;
            }
        }

        while (leftIdx < left.size()) {
            merged.add(left.get(leftIdx));
            leftIdx++;
        }

        while (rightIdx < right.size()) {
            merged.add(right.get(rightIdx));
            rightIdx++;
        }

        return merged;
    }
}
