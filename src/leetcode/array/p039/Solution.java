package leetcode.array.p039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    private List<List<Integer>> lists = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists.clear();
        
        Arrays.sort(candidates);
        combinationSum(candidates, 0, target, new Stack<Integer>());
        
        return lists;
    }

    private void combinationSum(int[] candidates, int index, int target, Stack<Integer> stack) {
        if (target == 0) {
            lists.add(new ArrayList<Integer>(stack));
            return;
        }
        
        else if (index >= candidates.length) return;
        
        for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
            stack.push(candidates[i]);
            combinationSum(candidates, i, target - candidates[i], stack);
            stack.pop();
        }
    }
    
    public static void main(String[] args) {
        int[] candidates = new int[] {2, 3, 6, 7};
        System.out.println(new Solution().combinationSum(candidates, 7));
    }
}