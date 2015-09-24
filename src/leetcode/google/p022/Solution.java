package leetcode.google.p022;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Theodore
 *
 *  简单递归就可以了
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        recursive(result, "", n, n);
        return result;
    }

    private void recursive(List<String> result, String s, int m, int n) {
        if (m == 0 && n == 0) result.add(s);
        if (m > n || m < 0 || n < 0) return;
        recursive(result, s + "(", m - 1, n);
        recursive(result, s + ")", m, n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3).toString());
    }
}