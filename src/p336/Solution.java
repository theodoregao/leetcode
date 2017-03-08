package p336;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String rword = new StringBuffer(word).reverse().toString();
            if (isPalindrome(word) && !word.equals("") && map.containsKey("")) {
                addPair(pairs, i, map.get(""));
                addPair(pairs, map.get(""), i);
            }
            if (!word.equals("") && map.containsKey(rword)) addPair(pairs, i, map.get(rword));
            
            for (int j = 1; j < word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                if (isPalindrome(left)) {
                    String rightReverse = new StringBuffer(right).reverse().toString();
                    if (map.containsKey(rightReverse)) addPair(pairs, map.get(rightReverse), i);
                }
                if (isPalindrome(right)) {
                    String leftReverse = new StringBuffer(left).reverse().toString();
                    if (map.containsKey(leftReverse)) addPair(pairs, i, map.get(leftReverse));
                }
            }
        }
        return pairs;
    }
    
    private void addPair(List<List<Integer>> pairs, int i, int j) {
        if (i == j) return;
        List<Integer> pair = new ArrayList<>();
        pair.add(i);
        pair.add(j);
        pairs.add(pair);
    }
    
    private boolean isPalindrome(String s) {
        for (int lo = 0, hi = s.length() - 1; lo < hi; lo++, hi--)
            if (s.charAt(lo) != s.charAt(hi)) return false;
        return true;
    }
    
    public static void main(String[] args) {
        for (List<Integer> list: new Solution().palindromePairs(new String[] {"aba","ba","a","caba"})) System.out.println(list);
//        System.out.println(new Solution().palindromePairs(new String[] {"abcd", "dcba", "lls", "s", "sssll"}).size());
//        System.out.println(new Solution().palindromePairs(new String[] {"a","abc","aba",""}).size());
//        System.out.println(new Solution().palindromePairs(new String[] {"aba","ba","a","caba"}).size());
    }
}