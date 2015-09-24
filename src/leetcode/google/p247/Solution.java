package leetcode.google.p247;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Theodore
 * 
 *  简单递归，注意00,000,0000格式不对
 */
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, false);
    }

    private List<String> findStrobogrammatic(int n, boolean flag) {
        List<String> results = new ArrayList<String>();
        if (n <= 0) return results;
        else if (n == 1) {
            results.addAll(Arrays.asList("0", "1", "8"));
            return results;
        }
        else if (n == 2) {
            if (flag) results.add("00");
            results.addAll(Arrays.asList("11", "69", "96", "88"));
            return results;
        }
        List<String> subResult = findStrobogrammatic(n - 2, true);
        for (String string: subResult) {
            if (flag) results.add("0" + string + "0");
            results.add("1" + string + "1");
            results.add("8" + string + "8");
            results.add("6" + string + "9");
            results.add("9" + string + "6");
        }
        return results;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findStrobogrammatic(0));
        System.out.println(new Solution().findStrobogrammatic(1));
        System.out.println(new Solution().findStrobogrammatic(2));
        System.out.println(new Solution().findStrobogrammatic(3));
        System.out.println(new Solution().findStrobogrammatic(4));
        System.out.println(new Solution().findStrobogrammatic(5));
    }
}