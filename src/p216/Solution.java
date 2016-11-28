package p216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        recursive(results, new LinkedList<Integer>(), new int[] {1,2,3,4,5,6,7,8,9}, 0, k, n);
        return results;
    }
    
    private void recursive(List<List<Integer>> results, LinkedList<Integer> current, int[] candidates, int pos, int count, int target) {
        if (count < 0) return;
        if (count == 0) {
            if (target == 0) results.add(copy(current));
            return;
        }
        else for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.addLast(candidates[i]);
                recursive(results, current, candidates, i + 1, count - 1, target - candidates[i]);
                current.removeLast();
            }
        }
    }
    
    private List<Integer> copy(List<Integer> list) {
        List<Integer> copy = new ArrayList<>();
        for (int i: list) copy.add(i);
        return copy;
    }
}