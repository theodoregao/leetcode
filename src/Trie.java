

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] characters = word.toCharArray();
        TrieNode trieNode = root;
        for (Character ch: characters) {
            trieNode = trieNode.put(ch);
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] characters = word.toCharArray();
        TrieNode trieNode = root;
        for (Character ch: characters) {
            trieNode = trieNode.get(ch);
            if (trieNode == null) break;
        }
        return trieNode != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return search(prefix);
    }
    
    
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");