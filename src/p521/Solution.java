package p521;

public class Solution {
    public int findLUSlength(String a, String b) {
        if (a == null && b == null) return -1;
        else if (a == null) return b.length();
        else if (b == null) return a.length();
        else if (a.equals(b)) return -1;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
        return a.length() > b.length() ? a.length() : b.length();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findLUSlength("aaa", "aaa"));
    }
}