package p422;

import java.util.List;

public class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        if (words.get(0).length() != n) return false;
        char[][] chars = new char[n][n];
        int i = 0, j = 0;
        for (String word: words) {
            for (char c: word.toCharArray()) {
                if (j >= n) return false;
                chars[i][j++] = c;
            }
            i++;
            j = 0;
        }
        for (i = 0; i < n; i++)
            for (j = i; j < n; j++)
                if (chars[i][j] != chars[j][i]) return false;
        return true;
    }
}