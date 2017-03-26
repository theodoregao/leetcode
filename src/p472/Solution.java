package p472;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        for (String word: words) trie.insert(word);
        
        List<String> list = new ArrayList<>();
        for (String word: words) if (trie.searchCombination(word)) list.add(word);
        return list;
    }
    
    static class Trie {
        Map<String, Boolean> combinations = new HashMap<>();
        Node root = new Node();
        
        void insert(String word) {
            if (!word.equals("")) root.insert(word.toCharArray(), 0, root);
        }
        
        int search(String word) {
            return root.search(1, word.toCharArray(), 0);
        }
        
        /**
         * if word combine with other strings, it will reach root more than once.
         */
        boolean searchCombination(String word) {
            return search(word) > 1;
        }
    }
    
    static class Node {
        Map<Character, Node> next = new HashMap<>();
        Node root = null;
        
        /**
         * insert string and link end node to root.
         */
        Node insert(char[] str, int index, Node root) {
            if (str.length == index) { this.root = root; return this; }
            if (!next.containsKey(str[index])) next.put(str[index], new Node());
            return next.get(str[index]).insert(str, index + 1, root);
        }
        
        /**
         * search string. if search succeed, it will return how many times it reach root, else return -1.
         */
        int search(int count, char[] str, int index) {
            if (str.length == index) return root != null ? count : -1;
            if (root != null) {
                int sr = root.search(count + 1, str, index);
                if (sr > 0) return sr;
            }
            if (!next.containsKey(str[index])) return -1;
            return next.get(str[index]).search(count, str, index + 1);
        }
    }
    
    public static void main(String[] args) {
        for (String str: new Solution().findAllConcatenatedWordsInADict(new String[] {"","a","aa","aaa"}))
            System.out.println(str);
    }
}