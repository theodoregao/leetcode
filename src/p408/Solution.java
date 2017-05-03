package p408;
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] str = word.toCharArray();
        int n = 0;
        int i = 0;
        for (i = 0; i < abbr.length() && n < str.length; i++) {
            if (Character.isDigit(abbr.charAt(i))) {
                if (abbr.charAt(i) == '0') return false;
                int s = i;
                int e = i;
                while (++e < abbr.length() && Character.isDigit(abbr.charAt(e))) ;
                long length = Long.parseLong(abbr.substring(s, e));
                if (length > Integer.MAX_VALUE) return false;
                n += length;
                i = e - 1;
            }
            else if (str[n++] != abbr.charAt(i)) return false;
        }
        return n == str.length && i == abbr.length();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().validWordAbbreviation("a", "01"));
        System.out.println(new Solution().validWordAbbreviation("internationalization", "i13z4n"));
        System.out.println(new Solution().validWordAbbreviation("apple", "a2e"));
        System.out.println(new Solution().validWordAbbreviation("apple", "a3e"));
        System.out.println(new Solution().validWordAbbreviation("applee", "a3e"));
        System.out.println(new Solution().validWordAbbreviation("hi", "hi1"));
    }
}