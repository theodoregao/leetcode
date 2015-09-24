package leetcode.google.p208;
class TrieNode {
    char ch;
    TrieNode[] nexts;
    boolean has;
    // Initialize your data structure here.
    TrieNode(char ch) {
        this.ch = ch;
        nexts = new TrieNode[26];
        has = false;
    }
    
    boolean has() {
        return has;
    }
    
    void setHas() {
        has = true;
    }
    
    TrieNode next(char ch) {
        return nexts[ch - 'a'];
    }
    
    TrieNode setNext(char ch) {
        if (next(ch) == null) nexts[ch - 'a'] = new TrieNode(ch);
        return next(ch);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('S');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() <= 0) return;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            node = node.setNext(chars[i]);
        }
        node.setHas();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() <= 0) return false;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            node = node.next(chars[i]);
            if (node == null) return false;
        }
        return node.has();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        if (prefix.length() <= 0) return true;
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            node = node.next(chars[i]);
            if (node == null) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("shun");
        trie.insert("gao");
        trie.insert("someone");
        trie.insert("gao");

        System.out.println(trie.search(""));
        System.out.println(trie.search("shu"));
        System.out.println(trie.search("shun"));
        System.out.println(trie.search("gao"));
        System.out.println(trie.search("someone"));
        System.out.println(trie.search("shungao"));
        
        System.out.println(trie.startsWith(""));
        System.out.println(trie.startsWith("shu"));
        System.out.println(trie.startsWith("shun"));
        System.out.println(trie.startsWith("gao"));
        System.out.println(trie.startsWith("someone"));
        System.out.println(trie.startsWith("shungao"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");