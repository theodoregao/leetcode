package p028;
class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("abc", "a"));
        System.out.println(new Solution().strStr("abc", "ab"));
        System.out.println(new Solution().strStr("abc", "b"));
        System.out.println(new Solution().strStr("abc", "bc"));
        System.out.println(new Solution().strStr("abc", "c"));
        System.out.println(new Solution().strStr("abc", "d"));
    }
}