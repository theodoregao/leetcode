package p522;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLUSlength(String[] strs) {
        int maxLength = -1;
        Map<String, Integer> map = new HashMap<>();
        for (String str: strs) {
            if (!map.containsKey(str)) map.put(str, 0);
            map.put(str, map.get(str) + 1);
        }
        
        Trie trie = new Trie();
        for (String str: map.keySet()) {
            if (map.get(str) >= 2) trie.insert(str);
        }
        
        for (String str: map.keySet()) {
            if (map.get(str) == 1) {
                System.out.println("find " + str + ": " + trie.search(str));
                if (!trie.search(str)) maxLength = Math.max(maxLength, str.length());
            }
        }
        return maxLength;
    }
    
    private static class Trie {
        private Node root = new Node();
        
        public void insert(String word) {
            root.insert(word.toCharArray(), 0);
        }
        
        public boolean search(String word) {
            return root.search(word.toCharArray(), 0);
        }
    }
    
    private static class Node {
        private Map<Character, Node> next = new HashMap<>();
        public void insert(char[] str, int index) {
            if (index == str.length) return;
            if (!next.containsKey(str[index])) next.put(str[index], new Node());
            next.get(str[index]).insert(str, index + 1);
        }
        public boolean search(char[] str, int index) {
            if (index == str.length) return true;
            if (next.containsKey(str[index]) && next.get(str[index]).search(str, index + 1)) return true;
            for (char c: next.keySet()) if (next.get(c).search(str, index)) return true;
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findLUSlength(new String[] {"aabbcc", "aabbcc","bc","bcc","aabbccc"}));
    }
}