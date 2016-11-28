package p040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Map<String, List<Integer>> results = new HashMap<String, List<Integer>>();
        recursive(results, new LinkedList<Integer>(), candidates, 0, target);
        List<List<Integer>> values = new ArrayList<List<Integer>>();
        for (List<Integer> list: results.values()) values.add(list);
        return values;
    }
    
    private void recursive(Map<String, List<Integer>> results, LinkedList<Integer> current, int[] candidates, int pos, int target) {
        if (target == 0) {
            String key = getKey(current);
            if (!results.containsKey(key)) results.put(key, copy(current));
        }
        else {
            for (int i = pos; i < candidates.length; i++)
                if (candidates[i] <= target) {
                    current.addLast(candidates[i]);
                    recursive(results, current, candidates, i + 1, target - candidates[i]);
                    current.removeLast();
                }
        }
    }
    
    private String getKey(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i: list) sb.append("*" + i);
        return sb.toString();
    }
    
    private List<Integer> copy(List<Integer> list) {
        List<Integer> copy = new ArrayList<>();
        for (Integer i: list) copy.add(i);
        return copy;
    }
}