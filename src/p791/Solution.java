package p791;
class Solution {
    public String customSortString(String S, String T) {
        if (T == null) return null;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < T.length(); ) {
                if (T.charAt(j) == S.charAt(i)) {
                    result.append(S.charAt(i));
                    T = T.substring(0, j) + T.substring(j + 1, T.length());
                }
                else {
                    j++;
                }
            }
        }
        result.append(T);
        return result.toString();
    }
}