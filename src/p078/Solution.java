package p078;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        recursive(lists, new ArrayList<Integer>(), nums, 0);
        return lists;
    }
    
    private void recursive(List<List<Integer>> lists, List<Integer> cur, int[] nums, int n) {
        if (n >= nums.length) {
            lists.add(new ArrayList<>(cur));
            return;
        }
        recursive(lists, cur, nums, n + 1);
        cur.add(cur.size(), nums[n]);
        recursive(lists, cur, nums, n + 1);
        cur.remove(cur.size() - 1);
    }
    
    public static void main(String[] args) {
        for (List<Integer> list: new Solution().subsets(new int[] {1,2,3}))
            System.out.println(list);
    }
}