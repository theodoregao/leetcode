package leetcode.array.p040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    private List<List<Integer>> lists = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists.clear();
        
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, target, new Stack<Integer>());
        
        return lists;
    }

    private void combinationSum2(int[] candidates, int index, int target, Stack<Integer> stack) {
        if (target == 0) {
            lists.add(new ArrayList<Integer>(stack));
            return;
        }
        if (index >= candidates.length) return;
        
        for (int i = index; i < candidates.length && target >= candidates[i]; /**/) {
            stack.push(candidates[i]);
            combinationSum2(candidates, i + 1, target - candidates[i], stack);
            stack.pop();
            do {i++;} while (i < candidates.length && candidates[i] == candidates[i - 1]);
        }
    }
    
    public static void main(String[] args) {
        int[] candidates = new int[] {2, 3, 3, 4, 4, 6, 7};
        System.out.println(new Solution().combinationSum2(candidates, 6));
    }
}