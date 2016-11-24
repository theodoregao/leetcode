package p425;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        Map<Character, Set<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String word: words) {
        	if (!map.containsKey(word.charAt(0))) map.put(word.charAt(0), new HashSet<String>());
        	map.get(word.charAt(0)).add(word);
        	set.add(word);
        }
        
        Map<String, List<String>> results = new HashMap<>();
        for (String word: set) {
        	LinkedList<String> square = new LinkedList<>();
        	square.addLast(word);
        	recursive(results, map, square, word);
        }
        
        List<List<String>> squares = new ArrayList<>();
        for (List<String> square: results.values()) squares.add(square);
        return squares;
    }
    
    private void recursive(Map<String, List<String>> results, Map<Character, Set<String>> words, LinkedList<String> square, String word) {
    	if (!check(square)) return;
    	
    	if (square.size() == word.length()) {
    		results.put(toString(square), copySquare(square));
    		return;
    	}

    	if (words.containsKey(word.charAt(square.size())))
    		for (String next: words.get(word.charAt(square.size()))) {
    			square.addLast(next);
	    		recursive(results, words, square, word);
	    		square.removeLast();
    		}
    }
    
    private boolean check(List<String> square) {
    	int n = square.size();
    	for (int i = 0; i < n; i++)
    		if (square.get(n - 1).charAt(i) != square.get(i).charAt(n - 1))
    			return false;
    	return true;
    }
    
    private String toString(List<String> square) {
    	StringBuilder sb = new StringBuilder();
    	for (String word: square) sb.append(word);
    	return sb.toString();
    }
    
    private List<String> copySquare(List<String> square) {
    	List<String> copy = new ArrayList<>();
    	copy.addAll(square);
    	return copy;
    }
}