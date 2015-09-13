package google.leetcode066;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Theodore
 *
 *  一个元素一个数字
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < digits.length; i++) {
            stack.push(digits[i]);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int one = 1;
        while (!stack.isEmpty()) {
            one += stack.pop();
            result.add(one % 10);
            one /= 10;
        }
        
        if (one > 0) {
            result.add(one);
        }
        
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(result.size() - i - 1);
        }
        return resultArray;
    }
}