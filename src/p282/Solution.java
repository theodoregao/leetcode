package p282;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(ans, num.toCharArray(), (long)(-target), "", 0, 0);
        return ans;
    }
    
    private void dfs(List<String> ans, char[] nums, long sum, String expression, int k, int pre) {
//        System.out.println("dfs() " + sum + ", " + k + ", " + pre + ": " + expression);
        if (k == nums.length && sum == 0) { ans.add(expression); return; }
        long val = 0;
        for (int i = k; i < nums.length; i++) {
            val = val * 10 + nums[i] - '0';
            if (val > Integer.MAX_VALUE) break;
            if (k == 0) dfs(ans, nums, sum + val, "" + val, i + 1, (int) val);
            else {
                dfs(ans, nums, sum + val, expression + "+" + val, i + 1, (int) val);
                dfs(ans, nums, sum - val, expression + "-" + val, i + 1, (int) -val);
                dfs(ans, nums, sum - pre + pre * val, expression + "*" + val, i + 1, (int) (pre * val));
            }
            if (nums[k] == '0') break;
        }
    }
    
    public static void main(String[] args) {
        for (String expression: new Solution().addOperators("123", 6)) System.out.println(expression);
//        for (String expression: new Solution().addOperators("232", 8)) System.out.println(expression);
//        for (String expression: new Solution().addOperators("105", 5)) System.out.println(expression);
//        for (String expression: new Solution().addOperators("00", 0)) System.out.println(expression);
//        for (String expression: new Solution().addOperators("3456237490", 9191)) System.out.println(expression);
    }
}