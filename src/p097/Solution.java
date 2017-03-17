package p097;
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
//      return isInterleaveRecursive(s1, s2, s3, s1.length() - 1, s2.length() - 1, s3.length() - 1);
        return isInterleaveDpRecursive(s1, s2, s3); 
        // the other solution is bottom up dp.
    }
    
    private boolean isInterleaveDpRecursive(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        Boolean[][][] dp = new Boolean[n1 + 1][n2 + 1][n3 + 1];
        for (int i = 0; i <= n1; i++) for (int j = 0; j <= n2; j++) dp[i][j][0] = true;
        return isInterleaveDpRecursive(dp, s1, s2, s3, s1.length(), s2.length(), s3.length());
    }
    
    private boolean isInterleaveDpRecursive(Boolean[][][] dp, String s1, String s2, String s3, int n1, int n2, int n3) {
        if (dp[n1][n2][n3] != null) return dp[n1][n2][n3];
        if (n1 == 0) return dp[n1][n2][n3] = s2.substring(0, n2).equals(s3.substring(0, n3));
        else if (n2 == 0) return dp[n1][n2][n3] = s1.substring(0, n1).equals(s3.substring(0, n3));
        char ch1 = s1.charAt(n1 - 1);
        char ch2 = s2.charAt(n2 - 1);
        char ch3 = s3.charAt(n3 - 1);
        boolean isInterleave = false;
        if (ch1 == ch3) isInterleave = isInterleaveDpRecursive(dp, s1, s2, s3, n1 - 1, n2, n3 - 1);
        if (!isInterleave && ch2 == ch3) return isInterleaveDpRecursive(dp, s1, s2, s3, n1, n2 - 1, n3 - 1);
        return dp[n1][n2][n3] = isInterleave;
    }
    
    private boolean isInterleaveRecursive(String s1, String s2, String s3, int n1, int n2, int n3) {
        if (n3 == -1) return true;
        else if (n1 == -1) return s2.substring(0, n2 + 1).equals(s3.substring(0, n3 + 1));
        else if (n2 == -1) return s1.substring(0, n1 + 1).equals(s3.substring(0, n3 + 1));
        char ch1 = s1.charAt(n1);
        char ch2 = s2.charAt(n2);
        char ch3 = s3.charAt(n3);
        boolean isInterleave = false;
        if (ch1 == ch3) isInterleave = isInterleaveRecursive(s1, s2, s3, n1 - 1, n2, n3 - 1);
        if (!isInterleave && ch2 == ch3) return isInterleaveRecursive(s1, s2, s3, n1, n2 - 1, n3 - 1);
        return isInterleave;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(new Solution().isInterleave("aabcc","dbbca","aadbbbaccc"));
        System.out.println(new Solution().isInterleave("baababbabbababbaaababbbbbbbbbbbaabaabaaaabaaabbaaabaaaababaabaaabaabbbbaabbaabaabbbbabbbababbaaaabab",
                "aababaaabbbababababaabbbababaababbababbbbabbbbbababbbabaaaaabaaabbabbaaabbababbaaaababaababbbbabbbbb",
                "babbabbabbababbaaababbbbaababbaabbbbabbbbbaaabbabaababaabaaabaabbbaaaabbabbaaaaabbabbaabaaaabbbbababbbababbabaabababbababaaaaaabbababaaabbaabbbbaaaaabbbaaabbbabbbbaaabaababbaabababbbbababbaaabbbabbbab"));
    }
}