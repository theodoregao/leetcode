package leetcode.facebook.p161;
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;
        String s1 = s.length() > t.length() ? s : t;
        String s2 = s.length() > t.length() ? t : s;
        int i;
        for (i = 0; i < s2.length(); i++) if (s1.charAt(i) != s2.charAt(i)) break;
        
        return s1.length() == s2.length() ?
                s1.substring(i + 1).equals(s2.substring(i + 1)) :
                s1.substring(i + 1).equals(s2.substring(i));
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isOneEditDistance("abc", "abcd"));
        System.out.println(new Solution().isOneEditDistance("abc", "abc"));
        System.out.println(new Solution().isOneEditDistance("abce", "abcd"));
        System.out.println(new Solution().isOneEditDistance("dabc", "abcd"));
        System.out.println(new Solution().isOneEditDistance("aabc", "abcd"));
        System.out.println(new Solution().isOneEditDistance("aabcd", "abcd"));
        System.out.println(new Solution().isOneEditDistance("abc", "abcd"));
    }
}