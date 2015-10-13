package leetcode.array.p229;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length <= 0) return result;
        
        int n1 = 0, n2 = 1;
        int c1 = 0, c2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n1) c1++;
            else if (nums[i] == n2) c2++;
            else if (c1 == 0) {
                n1 = nums[i];
                c1++;
            }
            else if (c2 == 0) {
                n2 = nums[i];
                c2++;
            }
            else {
                c1--;
                c2--;
            }
        }
        
        c1 = c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n1) c1++;
            else if (nums[i] == n2) c2++;
        }
        
        if (c1 > nums.length / 3) result.add(n1);
        if (c2 > nums.length / 3) result.add(n2);
        
        return result;
    }
}