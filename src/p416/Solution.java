package p416;
public class Solution {
	
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += nums[i];
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[] T = new boolean[sum + 1];
        boolean[] temp = new boolean[sum + 1];
        T[0] = temp[0] = true;
        
        for (int i = 0; i < n; i++) {
        	for (int k = 0; k <= sum; k++) temp[k] = T[k];
        	for (int k = nums[i]; k <= sum; k++)
        		T[k] = temp[k] || (temp[k - nums[i]]);
        }
        return T[sum];
    }
    
}