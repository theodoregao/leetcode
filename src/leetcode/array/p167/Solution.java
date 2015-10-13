package leetcode.array.p167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 1;
        int r = numbers.length;
        int sum;
        
        while (l < r) {
            sum = numbers[l - 1] + numbers[r - 1];
            if (sum == target) return new int[] {l, r};
            if (sum < target) l++;
            else r--;
        }
        
        return new int[] {-1, -1};
    }
    
    public static void main(String[] args) {
        for (Integer index: new Solution().twoSum(new int[] {2,  7, 11, 15}, 9))
            System.out.println(index);
    }
}