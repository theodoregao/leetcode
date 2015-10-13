package leetcode.array.p243;


public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int p1 = -words.length, p2 = words.length;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
                distance = Math.min(distance, Math.abs(p1 - p2));
            }
            if (words[i].equals(word2)) {
                p2 = i;
                distance = Math.min(distance, Math.abs(p1 - p2));
            }
        }
        
        return distance;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().shortestDistance
                (new String[] {"practice", "makes", "perfect", "coding", "makes"},
                        "coding", "makes"));
    }
}