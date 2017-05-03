package p560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySumBruteForce(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[] {1,1,1}, 1));
    }
}