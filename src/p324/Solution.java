package p324;

public class Solution {
    public void wiggleSort(int[] nums) {
    	partition(nums, 0, nums.length - 1);
        int median = nums[nums.length / 2];
        int lo = 0, hi = nums.length - 1, i = 0;
        while (i <= hi) {
        	if (nums[index(nums.length, i)] > median) swap(nums, index(nums.length, i++), index(nums.length, lo++));
        	else if (nums[index(nums.length, i)] < median) swap(nums, index(nums.length, i), index(nums.length, hi--));
        	else i++;
        }
    }
    
    private int index(int length, int pos) {
    	return (1 + pos * 2) % (length | 1);
    }
    
    private void partition(int[] nums, int lo, int hi) {
    	if (lo >= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        int v = nums[lo];
        while (i <= gt) {
            if (nums[i] < v) swap(nums, i++, lt++);
            else if (nums[i] > v) swap(nums, i, gt--);
            else i++;
        }
        if (lo <= nums.length / 2 && nums.length / 2 <= lt) partition(nums, lo, lt - 1);
        if (gt + 1 <= nums.length / 2 && nums.length / 2 <= hi) partition(nums, gt + 1, hi);
    }
    
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[] {1,5,1,1,6,4};
		new Solution().wiggleSort(nums);
		for (int i = 0; i < nums.length; i++) System.out.println(nums[i]);
	}
}