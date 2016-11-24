package p418;
public class Solution {
    
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // if the row start with word i, which word will next line start
        int[] dp = new int[sentence.length];
        int n = sentence.length;
        
        // i to j in the buffer string with length of len
        for (int k = 0, i = 0, j = 0, len = 0; k < n; k++) {
            // remove the first word and the space in the buffer
            if (len > 0) len -= sentence[i++ % n].length() + 1;
            while (len + sentence[j % n].length() <= cols) len += sentence[j++ % n].length() + 1;
            // it is OK to keep j beyond the array size, we can use it to calculate word count in the buffer
            dp[k] = j;
        }
        
        int count = 0;
        for (int i = 0, k = 0; i < rows; i++) {
            if (dp[k] == k) return 0;
            // how many words in this row
            count += dp[k] - k;
            // the next line with start with
            k = dp[k] % n;
        }
        
        return count / n;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().wordsTyping(new String[] {"I", "bb", "ccc", "dddd", "eeeee"}, 4, 10));
    }
    
}