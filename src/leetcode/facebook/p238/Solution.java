package leetcode.facebook.p238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int zeroLocation = 0;
        long product = 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ++zeroCount;
                if (zeroCount >= 2) return new int[nums.length];
                zeroLocation = i;
            }
            else product *= nums[i];
        }
        
        int[] products = new int[nums.length];
        if (zeroCount >= 1) {
            products[zeroLocation] = (int)product;
            return products;
        }
        
        for (int i = 0; i < nums.length; i++) {
            products[i] = (int)(product / nums[i]);
        }
        return products;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] products = new Solution().productExceptSelf(nums);
        for (int i = 0; i < products.length; i++) System.out.println(products[i]);
    }
}