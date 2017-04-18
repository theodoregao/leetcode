package p520;
public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) return false;
        if (word.toUpperCase().equals(word)) return true;
        if (word.toLowerCase().equals(word)) return true;
        if (word.equals(Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())) return true;
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("USA"));
        System.out.println(new Solution().detectCapitalUse("leetcode"));
        System.out.println(new Solution().detectCapitalUse("Google"));
        System.out.println(new Solution().detectCapitalUse("FlaG"));
    }
}