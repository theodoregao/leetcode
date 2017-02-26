package p055;
public class Solution {
    public boolean canJumpNaive(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        reachable[0] = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (reachable[i]) {
                for (int j = 1; j <= nums[i]; j++)
                    if (i + j < nums.length) reachable[i + j] = true;
            }
        }
        return reachable[nums.length - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[] {0}));
        System.out.println(new Solution().canJump(new int[] {0,1}));
        System.out.println(new Solution().canJump(new int[] {2,3,1,1,4}));
        System.out.println(new Solution().canJump(new int[] {3,2,1,0,4}));
        System.out.println(new Solution().canJump(new int[] {3,2,1,1,1,1,1,0,4}));
        System.out.println(new Solution().canJump(new int[] {3,2,1,1,1,1,1,1,4}));
    }
    
    public boolean canJumpBit(int[] nums) {
        BinaryIndexedTree bit = new BinaryIndexedTree(nums.length);
        bit.update(1, 1, 1);
        for (int i = 0; i < nums.length; i++) {
            if (bit.get(i + 1) > 0) {
                bit.update(i + 1, i + nums[i] + 1, 1);
            }
        }
        return bit.get(nums.length) > 0;
    }
    
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= nums.length - 1;
    }
    
    class BinaryIndexedTree {
        
        private int[] items;
        private int n;
        
        public BinaryIndexedTree(int n) {
            this.n = n;
            items = new int[n + 1];
        }
        
        private int lowBit(int pos) {
            return pos & -pos;
        }
        
        public void update(int pos, int value) {
            while (pos <= n) {
                items[pos] += value;
                pos += lowBit(pos);
            }
        }
        
        public void update(int s, int e, int value) {
            update(s, value);
            update(e + 1, -value);
        }
        
        public int get(int pos) {
            int sum = 0;
            while (pos > 0) {
                sum += items[pos];
                pos -= lowBit(pos);
            }
            return sum;
        }
    }
}