package leetcode.array.p018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length < 4) return lists;
        
        Arrays.sort(nums);
        
        int a, b, c, d;
        int sum;
        for (int i = 0; i < nums.length; /**/) {
            a = nums[i];
            for (int j = i + 1; j < nums.length; /**/) {
                b = nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    c = nums[left];
                    d = nums[right];
                    sum = a + b + c + d - target;
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        list.add(d);
                        lists.add(list);
                        
                        do {left++;} while (left < right && nums[left] == nums[left - 1]);
                        do {right--;} while (left < right && nums[right] == nums[right + 1]);
                    }
                    else if (sum < 0) left++; else right--;
                }
                while (j < nums.length && nums[j] == b) j++;    // 比较容易漏掉
            }
            while (i < nums.length && nums[i] == a) i++;    // 比较容易漏掉
        }
        
        return lists;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {-3,-2,-1,0,0,1,2,3};
        
        for (List<Integer> ints: new Solution().fourSum(nums, 0)) {
            System.out.println(ints.toString());
        }
    }
}