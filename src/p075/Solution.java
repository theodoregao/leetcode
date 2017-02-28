package p075;
public class Solution {
    public void sortColors2Pass(int[] nums) {
        int count0 = 0, count1 = 0 ;
        for (int i = 0; i < nums.length; i++)
        	if (nums[i] == 0) count0++;
        	else if (nums[i] == 1) count1++;
        count1 += count0;
        for (int i = 0; i < nums.length; i++)
        	if (i < count0) nums[i] = 0;
        	else if (i < count1) nums[i] = 1;
        	else nums[i] = 2;
    }
    
    public void sortColors(int[] nums) {
    	int lt = 0, i = 0, gt = nums.length - 1;
    	while (i <= gt) {
    		if (nums[i] < 1) swap(nums, lt++, i++);
    		else if (nums[i] > 1) swap(nums, i, gt--);
    		else i++;
    	}
    }
    
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    public static void main(String[] args) {
    	int[] values = new int[] {0,1,2,0,1,2,2,0,0,0,1,1,2,2,2,2,0};
    	new Solution().sortColors(values);
    	for (int v: values)
    		System.out.println(v);
	}
}