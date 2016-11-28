package p047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        recursive(results, new LinkedList<Integer>(), nums, new boolean[nums.length], nums.length);
        return results;
    }
    
    private void recursive(List<List<Integer>> list, LinkedList<Integer> current, int[] candidates, boolean[] flags, int count) {
        if (count == 0) list.add(new ArrayList<>(current));
        else for (int i = 0; i < flags.length; i++) {
            if (flags[i] || i > 0 && candidates[i - 1] == candidates[i] && !flags[i - 1]) continue;
            flags[i] = true;
            current.addLast(candidates[i]);
            recursive(list, current, candidates, flags, count - 1);
            current.removeLast();
            flags[i] = false;
        }
    }
    
    public static void main(String[] args) {
//        for (List<Integer> list: new Solution().permuteUnique(new int[] {1,1,2})) System.out.println(list);
        for (List<Integer> list: new Solution().permuteUnique(new int[] {3,3,0,3})) System.out.println(list);
    }
}