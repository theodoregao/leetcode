package leetcode.facebook.p125;
public class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toLowerCase().toCharArray();
        
        int left = 0, right = str.length - 1;
        
        while (left < right) {
            while (left < right && !Character.isAlphabetic(str[left]) && !Character.isDigit(str[left])) left++;
            while (left < right && !Character.isAlphabetic(str[right]) && !Character.isDigit(str[right])) right--;
            if (left < right && str[left] != str[right]) return false;
            left++;
            right--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
        System.out.println(new Solution().isPalindrome("1a2"));
    }
}