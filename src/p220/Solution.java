package p220;

import java.util.Arrays;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Number[] numbers = new Number[nums.length];
        for (int i = 0; i < nums.length; i++) numbers[i] = new Number(nums[i], i);
        Arrays.sort(numbers);
        for (int i = 1, j = 0; i < numbers.length; i++) {
            while (j < i && numbers[i].value - numbers[j].value > t) j++;
//            System.out.println(i + ", " + j + ": " + numbers[i].value + ", " + numbers[j].value + ": " + numbers[i].index + ", " + numbers[j].index);
            if (i > j && Math.abs(numbers[i].index - numbers[j].index) <= k) return true;
        }
        return false;
    }
    
    private class Number implements Comparable<Number> {
        long value;
        int index;
        Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Number o) {
            if (value != o.value) return value > o.value ? 1 : -1;
            return o.index - index;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[] {1,0,1,1},1,0));
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[] {-1,2147483647}, 1, 2147483647));
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[] {-1,2147483647,-2147483648,0}, 1, 2147483647));
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[] {-1,2147483647,0}, 1, 2147483647));
    }
}