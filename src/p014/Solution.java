package p014;
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs.length == 0) return prefix.toString();
        int n = strs[0].length();
        boolean found = false;
        for (int i = 0; !found && i < n; i++) {
            for (String s: strs)
                if (s.length() <= i || s.charAt(i) != strs[0].charAt(i)) {
                    found = true;
                    break;
                }
            if (!found) prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }
}