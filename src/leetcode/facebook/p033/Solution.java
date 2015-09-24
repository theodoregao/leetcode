package leetcode.facebook.p033;
public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left > right || right >= nums.length || left < 0) return -1;
        
        int mid = (left + right) / 2;
        
        if (target == nums[mid]) return mid;
        
        else if (nums[mid] < target) {
            int index = -1;
            if (nums[left] > nums[right]) { // 如果知道被旋转了，两边都要检测
                if ((index = search(nums, left, mid - 1, target)) != -1) return index;
            }
            return search(nums, mid + 1, right, target);
        }
        
        else {
            int index = -1;
            if (nums[left] > nums[right]) {
                if ((index = search(nums, mid + 1, right, target)) != -1) return index;
            }
            return search(nums, left, mid - 1, target);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        for (int i = -5; i <= 10; i++)
            System.out.println(i + ": " + new Solution().search(nums, i));
    }
}