import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> children;
    
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode get(char ch) {
        return children.get(ch);
    }
    
    public TrieNode put(char ch) {
        if (!children.containsKey(ch)) children.put(ch, new TrieNode());
        return children.get(ch);
    }
}