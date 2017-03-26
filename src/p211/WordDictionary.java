package p211;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    
    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.insert(word.toCharArray(), 0);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return root.search(word.toCharArray(), 0);
    }
    
    private static class Node {
        Map<Character, Node> next = new HashMap<>();
        boolean terminate = false;
        Node() {}
        void insert (char[] str, int index) {
            if (str.length == index) {terminate = true; return;}
            if (!next.containsKey(str[index])) next.put(str[index], new Node());
            next.get(str[index]).insert(str, index + 1);
        }
        boolean search(char[] str, int index) {
            if (str.length == index) return terminate;
            if (str[index] == '.') {
                for (Character key: next.keySet()) if (next.get(key).search(str, index + 1)) return true;
                return false;
            }
            if (!next.containsKey(str[index])) return false;
            return next.get(str[index]).search(str, index + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */