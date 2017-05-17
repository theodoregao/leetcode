package p163;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> results = new ArrayList<String>();
        
        long s = lower;
        long e;
        for (int i = 0; i <= nums.length; i++) {
            e = i == nums.length ? upper : ((long)nums[i] - 1);
            if (s <= e) results.add(makeRange(s, e));
            s = e + 2;
        }
        
        return results;
    }
    
    private String makeRange(long s, long e) {
        return s == e ? s + "" : s + "->" + e;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMissingRanges(new int[] {-2147483648,2147483647}, -2147483648,2147483647));
        System.out.println(new Solution().findMissingRanges(new int[] {2147483647}, 0, 2147483647));
        System.out.println(new Solution().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        System.out.println(new Solution().findMissingRanges(new int[]{}, 1, 1));
        System.out.println(new Solution().findMissingRanges(new int[]{-1000000000,-9999,0,1,2,10,100,1000,999999999,1000000000}, -1000000000, 1000000000));
    }
}