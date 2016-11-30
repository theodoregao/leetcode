package p410;
public class Solution {
    public int splitArray(int[] nums, int m) {
        long max = 0;
        long maxValue = 0;
        
        for (int v: nums) {
        	max += v;
        	maxValue = Math.max(maxValue, v);
        }
        
        return search(nums, m, maxValue, max);
    }
    
    private int search(int[] nums, int m, long lo, long hi) {
    	while (lo < hi) {
    		long mid = (lo + hi) >> 1;
    		if (valid(nums, m, mid)) hi = mid;
    		else lo = mid + 1;
    	}
    	return (int) lo;
    }
    
    private boolean valid(int[] nums, int m, long max) {
    	int count = 0;
    	long sum = 0;
    	for (int v: nums) {
    		sum += v;
    		if (sum > max) {
    			count++;
    			if (count >= m) return false;
    			sum = v;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().splitArray(new int[] {7,2,5,10,8}, 2));
	}
}