package p360;
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        if (a == 0) {
        	for (int i = 0; i < nums.length; i++)
        		result[i] = b * nums[i] + c;
        	if (b < 0) revert(result);
        	return result;
        }
        else {
	        double mid = -1.0 * b / a / 2;
	        int i = 0, j = nums.length - 1;
	        int k = nums.length - 1;
	        int cx;
	        while (i <= j) {
	        	if (Math.abs(nums[i] - mid) > Math.abs(nums[j] - mid))
	        		cx = nums[i++];
	        	else cx = nums[j--];
	        	result[k--] = a * cx * cx + b * cx + c;
	        }
	        if (a < 0) revert(result);
	        return result;
        }
    }
    
    private void revert(int[] nums) {
    	for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
    		int temp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = temp;
    	}
    }
}