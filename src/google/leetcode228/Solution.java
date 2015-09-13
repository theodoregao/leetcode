package google.leetcode228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        
        if (nums.length != 0) {
            int start = 0;
            for (int i = 1; i <= nums.length; i++) {
                if (i == nums.length || nums[i] - 1 != nums[i - 1]) {
                    if (start == i - 1) result.add("" + nums[start]);
                    else result.add(nums[start] + "->" + nums[i - 1]);
                    start = i;
                }
            }
        }
        
        return result;
    }
}