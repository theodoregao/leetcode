package leetcode.array.p031;

import java.util.Arrays;

/**
 * 生成字典序
 * 
    2763541 （找最后一个正序35）
    2763541 （找3后面比3大的最后一个数4）
    2764531 （交换3,4的位置）
    2764135 （把4后面的5,3,1反转）

 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        
        int i, j;
        for (i = nums.length - 2; i >= 0; i--) if (nums[i] < nums[i + 1]) break;
        
        if (i < 0) {Arrays.sort(nums); return;}
        
        for (j = nums.length - 1; j > 0; j--) if (nums[j] > nums[i]) break;
        swap(nums, i, j);
        
        reverse(nums, i + 1, nums.length - 1);
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++; r--;
        }
    }
    
    public static void main(String[] args) {
        int nums[] = new int[] {0, 1, 2, 3, 4};
        for (int k = 0; k < 120; k++) {
            new Solution().nextPermutation(nums);
            System.out.print(k + ": ");
            for (int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
            System.out.println();
        }
    }
}