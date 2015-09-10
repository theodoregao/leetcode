package google.leetcode163;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Theodore
 *
 *  一次扫描数组
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> results = new ArrayList<String>();
        
        int s = lower;
        int e;
        for (int i = 0; i <= nums.length; i++) {
            e = i == nums.length ? upper : (nums[i] - 1);
            if (s <= e) results.add(makeRange(s, e));
            s = e + 2;
        }
        
        return results;
    }
    
    private String makeRange(int s, int e) {
        return s == e ? s + "" : s + "->" + e;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        System.out.println(new Solution().findMissingRanges(new int[]{}, 1, 1));
        System.out.println(new Solution().findMissingRanges(new int[]{-1000000000,-9999,0,1,2,10,100,1000,999999999,1000000000}, -1000000000, 1000000000));
    }
}