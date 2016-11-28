package p077;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        recursive(results, new LinkedList<Integer>(), 1, k, n);
        return results;
    }
    
    private void recursive(List<List<Integer>> results, LinkedList<Integer> current, int pos, int count, int n) {
        if (count == 0) results.add(copy(current));
        else if (count > 0) {
            for (int i = pos; i <= n; i++) {
                current.addLast(i);
                recursive(results, current, i + 1, count - 1, n);
                current.removeLast();
            }
        }
    }
    
    private List<Integer> copy(List<Integer> list) {
        List<Integer> copy = new ArrayList<>();
        for (Integer i: list) copy.add(i);
        return copy;
    }
    
    public static void main(String[] args) {
        for (List<Integer> list: new Solution().combine(4, 2))
            System.out.println(list);
    }
}