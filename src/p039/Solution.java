package p039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        recursive(results, new LinkedList<Integer>(), candidates, 0, target);
        return results;
    }
    
    private void recursive(List<List<Integer>> results, LinkedList<Integer> current, int[] candidates, int pos, int target) {
        if (target == 0) {
            results.add(copy(current));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.addLast(candidates[i]);
                recursive(results, current, candidates, i, target - candidates[i]);
                current.removeLast();
            }
        }
    }
    
    private List<Integer> copy(List<Integer> list) {
        List<Integer> copy = new ArrayList<>();
        for (Integer i: list) copy.add(i);
        return copy;
    }
}