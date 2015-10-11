package leetcode.array.p126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// not finished yet
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        wordList.add(endWord);
        
        int n = beginWord.length();
        List<String> queue = new LinkedList<String>();
        List<Integer> lengths = new LinkedList<Integer>();
        queue.add(beginWord);
        lengths.add(1);
        
        String str, nextStr;
        int length;
        int maxIndex = Integer.MAX_VALUE;
        
        for (int index = 0; index < queue.size(); index++) {
            str = queue.get(index);
            length = lengths.get(index);
            if (length >= maxIndex) continue;
            
            for (int k = 0; k < n; k++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    nextStr = str.substring(0, k) + ch + str.substring(k + 1);
                    if (nextStr.equals(endWord)) result.add(Arrays.asList(endWord));
                    if (wordList.contains(nextStr)) {
                        wordList.remove(nextStr);
                        queue.add(nextStr);
                        lengths.add(length + 1);
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[] {"hot", "dot", "dog", "lot", "log"});
        System.out.println(new Solution().findLadders(beginWord, endWord, new HashSet<String>(wordList)));
    }
}