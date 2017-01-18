package p388;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        Map<Integer, Integer> paths = new HashMap<>();
        int tabCount;
        int maxLength = 0;
        for (String token: tokens) {
            tabCount = 0;
            while (token.startsWith("\t")) {
                tabCount++;
                token = token.substring(1);
            }
            if (token.contains(".")) {
                int length = token.length();
                for (int i = 0; i < tabCount; i++) length += paths.get(i) + 1;
                maxLength = Math.max(maxLength, length);
            }
            else paths.put(tabCount, token.length());
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(new Solution().lengthLongestPath("a.txt"));
    }
}