package leetcode.facebook.p015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int i = 0; i <= nums.length - 3; /* */) {
            int a = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if (sum == 0) list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                // 这两行是关键
                if (sum <= 0) while (j < k && nums[j] == b) j++;
                if (sum >= 0) while (j < k && nums[k] == c) k--;
            }
            while (i < nums.length && nums[i] == a) i++; // 这行是关键
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new Solution().threeSum(new int[]{0, 0, 0}));
    }
}