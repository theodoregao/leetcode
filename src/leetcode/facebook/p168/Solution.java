package leetcode.facebook.p168;
public class Solution {
    public String convertToTitle(int n) {
        String s = "";
        do {
            --n;
            s = (char)('A' + n % 26) + s;
            n /= 26;
        } while (n > 0);
        return s;
    }
    
    public static void main(String[] args) {
        for (int i = 1; i < 27 * 27; i++)
            System.out.println(new Solution().convertToTitle(i));
    }
}