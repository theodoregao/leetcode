package p784;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        recursive(list, S, "");
        return list;
    }
    
    private void recursive(List<String>list, String remain, String s) {
        if (remain.length() == 0) {
            list.add(s);
            return;
        }
        if (Character.isDigit(remain.charAt(0))) {
            recursive(list, remain.substring(1), s + remain.charAt(0));
        }
        else {
            recursive(list, remain.substring(1), s + Character.toLowerCase(remain.charAt(0)));
            recursive(list, remain.substring(1), s + Character.toUpperCase(remain.charAt(0)));
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
    }
}