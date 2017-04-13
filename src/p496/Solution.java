package p496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElementBruteForce(int[] findNums, int[] nums) {
        int[] greater = new int[findNums.length];
        if (greater.length == 0) return greater;
        int[] maxs = new int[nums.length];
        int max = nums[nums.length - 1];
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            index.put(nums[i], i);
            max = maxs[i] = Math.max(max, nums[i]);
        }
        for (int i = 0; i < findNums.length; i++)
            if (findNums[i] < maxs[index.get(findNums[i])]) {
                    for (int j = index.get(findNums[i]) ; maxs[j] > findNums[i]; j++)
                        if (nums[j] > findNums[i]) {
                            greater[i] = nums[j];
                            break;
                        }
            }
            else greater[i] = -1;
        return greater;
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums)
            if (stack.isEmpty() || stack.peek() > i) stack.push(i);
            else {
                while (!stack.isEmpty() && stack.peek() < i) map.put(stack.pop(), i);
                stack.push(i);
            }
        int[] r = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) r[i] = map.containsKey(findNums[i]) ? map.get(findNums[i]) : -1;
        return r;
    }
    
    public static void main(String[] args) {
        for (int i: new Solution().nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2})) System.out.println(i);
        for (int i: new Solution().nextGreaterElement(new int[] {2,4}, new int[] {1,2,3,4})) System.out.println(i);
    }
}