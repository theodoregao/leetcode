package p487;
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int with1 = 0;
        int without1 = 0;
        int max = 0;
        
        for (int n: nums) {
        	if (n == 0) {
        		without1 = with1 + 1;
        		with1 = 0;
        	}
        	else {
        		without1++;
        		with1++;
        	}
    		max = Math.max(max, without1);
        }
        return max;
    }
}