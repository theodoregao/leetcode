package p525;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] counts = new int[nums.length];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            counts[i] = (cur += nums[i] == 0 ? -1 : 1);
            map.put(cur, i);
        }
        int max = map.containsKey(0) ? map.get(0) + 1 : 0;
        for (int i = 0; i < counts.length; i++) {
            max = Math.max(max, map.get(counts[i]) - i);
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[] {0,1,1,1,0}));
        System.out.println(new Solution().findMaxLength(new int[] {1,1,1}));
    }
}