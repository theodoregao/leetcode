package p482;
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer sb = new StringBuffer();
        for (char c: S.toCharArray())
            if (Character.isAlphabetic(c)) sb.append(Character.toUpperCase(c));
            else if (Character.isDigit(c)) sb.append(c);
        if (sb.toString().equals("")) return "";
        sb.reverse();
        StringBuffer s = new StringBuffer();
        int n = (sb.length() + K - 1) / K;
        for (int i = 0; i < n; i++) s.append(sb.subSequence(i * K, Math.min(sb.length(), (i + 1) * K))).append("-");
        return s.reverse().toString().substring(1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 4));
        System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 3));
        System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 2));
        System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 1));
        System.out.println(new Solution().licenseKeyFormatting("2", 1));
        System.out.println(new Solution().licenseKeyFormatting("", 1));
        System.out.println(new Solution().licenseKeyFormatting("---", 1));
    }
}