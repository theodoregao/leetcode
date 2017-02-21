package p471;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String encode(String s) {
        Map<String, String> map = new HashMap<>();
        return recursion(map, s);
    }
    
    private String recursion(Map<String, String> map, String str) {
//        System.out.println("recursion() " + str);
        if (str.length() <= 4) return str;
        if (map.containsKey(str)) return map.get(str);
        String candidate = str;
        for (int len = 1; len < str.length(); len++) {
            String encodeString = getEncodeString(map, str, len);
            candidate = candidate.length() >= encodeString.length() ? encodeString : candidate;
        }

        for (int i = 1; i < str.length(); i++) {
            String recursiveString = recursion(map, str.substring(0, i)) + recursion(map, str.substring(i));
            candidate = candidate.length() >= recursiveString.length() ? recursiveString : candidate;
        }
        map.put(str, candidate);
//        System.out.println("recursion() " + str + " returns " + candidate);
        return candidate;
    }
    
    private String getEncodeString(Map<String, String> map, String str, int len) {
//        System.out.println("getEncodeString() " + str + ", len=" + len);
        int n = str.length() / len;
        if (len * n != str.length()) return str;
        for (int i = 1; i < n; i++) if (!str.substring((i - 1) * len, i * len).equals(str.substring(i * len, (i + 1) * len))) return str;
        String candidate = n + "[" + recursion(map, str.substring(0, len)) + "]";
        candidate = str.length() >= candidate.length() ? candidate : str;
//        System.out.println("getEncodeString() " + str + ", len=" + len + " returns " + candidate);
        return candidate;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().encode("aaa"));
        System.out.println(new Solution().encode("aaaaa"));
        System.out.println(new Solution().encode("aaaaaaaaaa"));
        System.out.println(new Solution().encode("aabcaabcd"));
        System.out.println(new Solution().encode("abbbabbbc"));
        System.out.println(new Solution().encode("abbbabbbcabbbabbbc"));
        System.out.println(new Solution().encode("aabcccccddd"));
        System.out.println(new Solution().encode("sdfeegfeegi"));
        System.out.println(new Solution().encode("feegfeeg"));
    }
}