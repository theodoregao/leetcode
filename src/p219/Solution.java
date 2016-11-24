package p219;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]))
                if (i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(new int[] {-1, -1}, 1));
        System.out.println(new Solution().containsNearbyDuplicate(new int[] {99, 99}, 2));
    }
    
}