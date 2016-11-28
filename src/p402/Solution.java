package p402;
public class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        char[] chars = num.toCharArray();
        int m = n - k;
        char[] result = new char[m];
        for (int i = 0, j = 0; i < chars.length; i++) {
            while (j > 0 && m - j < n - i && result[j - 1] > chars[i]) j--;
            if (j < m) result[j++] = chars[i];
        }
        int index = 0;
        for (; index < m && result[index] == '0'; index++) ;
        return index == m ? "0" : new String(result, index, m - index);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("1432219", 3));
        System.out.println(new Solution().removeKdigits("10200", 1));
        System.out.println(new Solution().removeKdigits("10", 2));
    }
}