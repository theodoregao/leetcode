package p555;
public class Solution {
    public String splitLoopedString(String[] strs) {
        String str = "";
        int[] indices = new int[strs.length + 1];
        for (int i = 0; i < strs.length; i++) {
            indices[i + 1] = indices[i] + strs[i].length();
            str += less(strs[i], reverse(strs[i])) ? reverse(strs[i]) : strs[i];
        }
        int length = str.length();
        String max = str;
        str += str;
        char[] chs = str.toCharArray();
        
        for (int i = 0, j = 1; i < length; i++) {
            max = less(max, new String(chs, i, length)) ? new String(chs, i, length) : max;
            reverse(chs, indices[j - 1], indices[j] - 1);
            reverse(chs, indices[j - 1] + length, indices[j] + length - 1);
            max = less(max, new String(chs, i, length)) ? new String(chs, i, length) : max;
            reverse(chs, indices[j - 1], indices[j] - 1);
            reverse(chs, indices[j - 1] + length, indices[j] + length - 1);
            if (indices[j] < i) j++;
        }
        return max;
    }
    
    private boolean less(String a, String b) {
        return a.compareTo(b) < 0;
    }
    
    private String reverse(String str) {
        char[] chs = str.toCharArray();
        reverse(chs, 0, str.length() - 1);
        return new String(chs);
    }
    
    private void reverse(char[] str, int lo, int hi) {
        for (int i = lo, j = hi; i < j; i++, j--) swap(str, i, j);
    }
    
    private void swap(char[] chs, int i, int j) {
        char ch = chs[i];
        chs[i] = chs[j];
        chs[j] = ch;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().splitLoopedString(new String[] {"abc", "xyz"}));
        System.out.println(new Solution().splitLoopedString(new String[] {"abc", "zyx"}));
        System.out.println(new Solution().splitLoopedString(new String[] {"a", "b", "c"}));
        System.out.println(new Solution().splitLoopedString(new String[] {"ab","xy","cd","aaa","bab"}));
        System.out.println(new Solution().splitLoopedString(new String[] {"lc", "evol", "cdy"}));
        System.out.println(new Solution().splitLoopedString(new String[] {"awe","zzzdcasf","awefawz","awefawfae","awefaw","ewaee"}));
    }
}