package p494;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findTargetSumWaysRecursive(int[] nums, int s) {
        Map<Integer, Integer> map = new HashMap<>();
        return recursive(map, nums, nums.length - 1, s);
    }
    
    private int recursive(Map<Integer, Integer> map, int[] nums, int index, int sum) {
        if (index < 0) return sum == 0 ? 1 : 0;
        int combination = combine(index, sum);
        if (map.containsKey(combination)) return map.get(combination);
        map.put(combination, recursive(map, nums, index - 1, sum + nums[index]) + recursive(map, nums, index - 1, sum - nums[index]));
        return map.get(combination);
    }
    
    private int combine(int index, int sum) {
        return (sum << 7) + index;
    }
    

    public int findTargetSumWays(int[] nums, int s) {
        Map<Integer, Map<Integer, Integer>> maps = new HashMap<>();
        maps.put(0, new HashMap<Integer, Integer>());
        maps.get(0).put(combine(0, 0), 1);
        for (int i = 1; i <= nums.length; i++) {
            Map<Integer, Integer> preMap = maps.get(i - 1);
            Map<Integer, Integer> curMap = new HashMap<>();
            maps.put(i, curMap);
            for (Integer preValue: preMap.keySet()) {
                if (!curMap.containsKey(preValue - nums[i - 1])) curMap.put(preValue - nums[i - 1], 0);
                curMap.put(preValue - nums[i - 1], curMap.get(preValue - nums[i - 1]) + preMap.get(preValue));
                if (!curMap.containsKey(preValue + nums[i - 1])) curMap.put(preValue + nums[i - 1], 0);
                curMap.put(preValue + nums[i - 1], curMap.get(preValue + nums[i - 1]) + preMap.get(preValue));
            }
        }
        Map<Integer, Integer> map = maps.get(nums.length);
        return map.containsKey(s) ? map.get(s) : 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[] {0, 1, 2, 3, 4, 5, 1, 1, 4, 3, 2, 1, 1, 1, 1}, 12));
    }
}