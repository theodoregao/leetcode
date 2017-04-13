package p503;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] temp = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) temp[i] = temp[i + nums.length] = nums[i];
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) map.put(stack.pop(), temp[i]);
            stack.push(i);
        }
        int[] r = new int[nums.length];
        for (int i = 0; i < r.length; i++) r[i] = map.containsKey(i) ? map.get(i) : -1;
        return r;
    }
    
    public static void main(String[] args) {
        for (int i: new Solution().nextGreaterElements(new int[] {1,2,1,5,7,4})) System.out.println(i);
    }
}