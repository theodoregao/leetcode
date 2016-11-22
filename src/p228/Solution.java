package p228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) return ranges;
        
        int n = nums.length;
        int k = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                ranges.add(getRange(k, nums[i - 1]));
                k = nums[i];
            }
        }
        ranges.add(getRange(k, nums[n - 1]));
        return ranges;
    }
    
    private String getRange(int s, int e) {
        if (s != e) return new String(s + "->" + e);
        else return "" + s;
    }
    
    public static void main(String[] args) {
        for (String range: new Solution().summaryRanges(new int[] {0,1,2,4,5,7})) {
            System.out.println(range);
        }
    }
}