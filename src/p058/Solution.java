package p058;

public class Solution {
    
    public int lengthOfLastWord(String s) {
        String[] tokens = s.split(" ");
        if (tokens.length == 0) return 0;
        else return tokens[tokens.length - 1].length();
    }
    
}