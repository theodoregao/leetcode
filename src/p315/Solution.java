package p315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int[] sortedNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) sortedNum[i] = nums[i];
        Arrays.sort(sortedNum);
        Map<Integer, Integer> map = new HashMap<>();
        int n = 0;
        map.put(sortedNum[0], ++n);
        for (int i = 1; i < sortedNum.length; i++) if (sortedNum[i] != sortedNum[i - 1]) map.put(sortedNum[i], ++n);
        BinaryIndexedTree bit = new BinaryIndexedTree(n);
        for (int i = 0; i < nums.length; i++) bit.update(map.get(nums[i]), 1);
        for (int i = 0; i < nums.length; i++) {
            int index = map.get(nums[i]);
            bit.update(index, -1);
            list.add(bit.get(index - 1));
        }
        return list;
    }
    
    private static class BinaryIndexedTree {
        private int n;
        private int[] items;
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
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(BinaryIndexedTree.class.getSimpleName());
            sb.append("{");
            for (int i = 1; i <= n; i++) sb.append(get(i)).append(",");
            sb.append("}");
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        for (int i: new Solution().countSmaller(new int[] {5,2,6,5,2,2,1,1})) System.out.println(i);
    }
}