package pp1249;

class Solution {
    public String minRemoveToMakeValid(String s) {
        int totalOpenCount = 0;
        int availableCount = 0;
        final StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                totalOpenCount++;
                availableCount++;
            } else if (ch == ')') {
                if (availableCount == 0) {
                    continue;
                }
                availableCount--;
            }
            sb.append(ch);
        }
        
        totalOpenCount -= availableCount;
        final StringBuilder result = new StringBuilder();
        for (char ch: sb.toString().toCharArray()) {
            if (ch == '(') {
                totalOpenCount--;
                if (totalOpenCount < 0) {
                    continue;
                }
            }
            result.append(ch);
        }
        return result.toString();
    }
}
