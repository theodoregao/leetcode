package p548;
// Not pass
public class Solution {
    public boolean splitArray(int[] nums) {
        BinaryIndexedTree bit = new BinaryIndexedTree(nums);
        for (int i = 1; i < nums.length; i++) {
            int sum1 = bit.get(0, i - 1);
        	for (int j = i + 2; j < nums.length; j++) {
        	    int sum2 = bit.get(i + 1, j - 1);
        		if (sum1 == sum2) for (int k = j + 2; k < nums.length - 1; k++) {
        			int sum3 = bit.get(j + 1, k - 1);
        			if (sum2 == sum3 && bit.get(k + 1, nums.length - 1) == sum3)
        			    return true;
        		}
        	}
        }
        return false;
    }
    
    private static class BinaryIndexedTree {
    	private int[] items;
    	private int n;
    	public BinaryIndexedTree(int[] nums) {
    		n = nums.length;
    		items = new int[nums.length + 1];
    		for (int i = 0; i < n; i++) update(i + 1, nums[i]);
    	}
    	private int lowbit(int pos) { return pos & -pos;}
    	public void update(int pos, int val) {
    		while (pos <= n) {
    			items[pos] += val;
    			pos += lowbit(pos);
    		}
    	}
        public int get(int pos) {
            int sum = 0;
            while (pos > 0) {
                sum += items[pos];
                pos -= lowbit(pos);
            }
            return sum;
        }
        public int get(int lo, int hi) {
        	return get(hi + 1) - get(lo);
        }
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().splitArray(new int[]{1,2,1,2,1,2,1}));
	}
}