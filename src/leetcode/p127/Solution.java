package leetcode.p127;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        List<String> queue = new LinkedList<String>();
        List<Integer> lengths = new LinkedList<Integer>();
        queue.add(beginWord);
        lengths.add(1);
        int index = 0;
        String str, nextStr;
        int length;
        int n = beginWord.length();
        
        while (index < queue.size()) {
            str = queue.get(index);
            length = lengths.get(index);
            if (str.equals(endWord)) return length;
            for (int k = 0; k < n; k++) {
                for (int ch = 'a'; ch <= 'z'; ch++) {
                    nextStr = str.substring(0, k) + (char)ch + str.substring(k + 1);
                    if (wordList.contains(nextStr)) {
                        queue.add(nextStr);
                        lengths.add(length + 1);
                        wordList.remove(nextStr);
                    }
                }
            }
            index++;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[] {"hot", "dot", "dog", "lot", "log"});
        System.out.println(new Solution().ladderLength(beginWord, endWord, new HashSet<String>(wordList)));
    }
}