package leetcode.google.p139;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Theodore
 *
 *  DP，从前往后构造结果
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] finds = new boolean[s.length() + 1];
        finds[0] = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (!finds[i]) continue;
            
            for (String word: wordDict) {
                if (i + word.length() <= s.length() &&
                        s.substring(i, i + word.length()).equals(word)) {
                    finds[i + word.length()] = true;
                }
            }
        }
        
        return finds[s.length()];
    }
    
    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("leet");
        wordDict.add("let");
        wordDict.add("code");
        wordDict.add("cod");
        System.out.println(new Solution().wordBreak("codletleetcode", wordDict));
    }
}