package p523;
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        return dpSolution(nums, k);
    }
    
    private boolean dpSolution(int[] nums, int k) {
        if (k < 0) k = -k;
        long[] sum = new long[nums.length];
        long[] cur = new long[nums.length];
        long[] pre = new long[nums.length];
        for (int i = 0; i < nums.length; i++) sum[i] = nums[i];
        for (int d = 1; d < nums.length; d++) {
            for (int i = 0; i < nums.length; i++) pre[i] = cur[i];
            for (int i = 0; i < nums.length; i++) cur[i] = sum[i];
            for (int i = d; i < nums.length; i++) {
                sum[i] = cur[i - 1] + cur[i] - pre[i - 1];
                if (k == 0) { if (sum[i] == 0) return true; }
                else if (sum[i] % k == 0) return true;
            }
        }
        return false;
    }
    
    private boolean bitSolution(int[] nums, int k) {
        BinaryIndexedTree bit = new BinaryIndexedTree(nums);
        for (int i = 1; i <= nums.length; i++)
            for (int j = i + 1; j <= nums.length; j++)
                if (check(bit, i, j, k)) return true;
        return false;
    }
    
    private boolean check(BinaryIndexedTree bit, int i, int j, int k) {
        long sum = bit.get(j) - bit.get(i - 1);
        if (k == 0) return sum == 0;
        else return sum % k == 0;
    }
    
    private static class BinaryIndexedTree {
        int[] items;
        int n;
        public BinaryIndexedTree(int[] nums) {
            n = nums.length;
            items = new int[n + 1];
            for (int i = 1; i <= nums.length; i++)
                update(i, nums[i - 1]);
        }
        
        private int lowBit(int pos) {
            return pos & -pos;
        }
        
        private void update(int pos, int val) {
            while (pos <= n) {
                items[pos] += val;
                pos += lowBit(pos);
            }
        }
        
        public long get(int pos) {
            long sum = 0;
            while (pos > 0) {
                sum += items[pos];
                pos -= lowBit(pos);
            }
            return sum;
        }
    }
}