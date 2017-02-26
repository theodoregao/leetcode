package p288;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {
	
	private Set<String> dictionary;
	private Map<String, Integer> map;

    public ValidWordAbbr(String[] dictionary) {
    	this.dictionary = new HashSet<>();
        map = new HashMap<>();
        for (String word: dictionary) {
        	if (this.dictionary.contains(word)) continue;
        	this.dictionary.add(word);
        	String attr = formAbbr(word);
        	if (!map.containsKey(attr)) map.put(attr, 0);
        	map.put(attr, map.get(attr) + 1);
        }
        	
    }
    
    public boolean isUnique(String word) {
        return dictionary.contains(word) && map.get(formAbbr(word)) < 2
        		|| !dictionary.contains(word) && !map.containsKey(formAbbr(word));
    }
    
    private String formAbbr(String word) {
    	if (word.length() <= 2) return word;
    	return word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */