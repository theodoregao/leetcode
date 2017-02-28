package p005;
public class Solution {
    
    // not pass the judge yet. don't know how to improve.
    public String longestPalindrome(String s) {
        boolean[][] valids = new boolean[s.length()][s.length()];
        String maxString = s.substring(0, 1);
        for (int len = 2; len <= s.length(); len++) {
            for (int lo = 0; lo <= s.length() - len; lo++) {
                int hi = lo + len - 1;
                if (s.charAt(lo) == s.charAt(hi) && (lo + 1 >= hi - 1 || valids[lo + 1][hi - 1])) {
                    valids[lo][hi] = true;
                    if (hi - lo + 1 > maxString.length()) maxString = s.substring(lo, hi + 1);
                }
                else valids[lo][hi] = false;
            }
        }
        return maxString;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
        System.out.println(new Solution().longestPalindrome("babadab"));
    }
}