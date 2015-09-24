package leetcode.facebook.p001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(nums[0], 1);
        for (int i = 2; i <= nums.length; i++) {
            if (map.containsKey(target - nums[i - 1]))
                return new int[]{map.get(target - nums[i - 1]), i};
            else map.put(nums[i - 1], i);
        }
        return new int[]{};
    }
}