package p303;
public class NumArray {
	
	int n;
	int[] items;

	private int lowbit(int pos) {
		return pos & -pos;
	}
	
	private void update(int pos, int v) {
		while (pos <= n) {
			items[pos] += v;
			pos += lowbit(pos);
		}
	}
	
	private int get(int pos) {
        int sum = 0;
        while (pos > 0) {
            sum += items[pos];
            pos -= lowbit(pos);
        }
        return sum;
    }
	
    public NumArray(int[] nums) {
    	items = new int[nums.length + 1];
        n = nums.length;
        for (int i = 1; i <= nums.length; i++) update(i, nums[i - 1]);
    }
    
    public int sumRange(int i, int j) {
        return get(j + 1) - get(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */