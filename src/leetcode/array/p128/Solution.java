package leetcode.array.p128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) set.add(nums[i]);
        
        int max = 0;
        int length;
        int left, right;
        while (!set.isEmpty()) {
            left = right = set.iterator().next();
            set.remove(left);
            length = 1;
            while (set.contains(--left)) {
                length++;
                set.remove(left);
            }
            while (set.contains(++right)) {
                length++;
                set.remove(right);
            }
            max = Math.max(max, length);
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }
}