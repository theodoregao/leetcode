package leetcode.facebook.p215;

import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest(int[] nums, int left, int right, int k) {
        int pos = partition(nums, left, right);
        
        if (pos == k) return nums[k];
        else if (pos > k) return findKthLargest(nums, left, pos - 1, k);
        else return findKthLargest(nums, pos + 1, right, k);
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, random.nextInt(nums.length));
        }
    }
    
    private int partition(int[] nums, int left, int right){
        int i = left;
        int j = right;
        int pivot = nums[left];
        while(i < j){
            while(i < j && nums[j] <= pivot) j--;
            nums[i] = nums[j];
            while(i < j && nums[i] >= pivot) i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int value = nums[i];
        nums[i] = nums[j];
        nums[j] = value;
    }
}