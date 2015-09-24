package leetcode.facebook.p038;
public class Solution {
    public String countAndSay(int n) {
        String sequence = "1";
        String temp;
        int index;
        while (--n > 0) {
            temp = "";
            index = 0;
            char[] chs = sequence.toCharArray();
            for (int i = 1; i < sequence.length(); i++) {
                if (chs[i] != chs[index]) {
                    temp += (i - index) + "" + chs[index];
                    index = i;
                }
            }
            sequence = temp + (sequence.length() - index) + "" + chs[index];
        }
        return sequence;
    }
    
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++)
            System.out.println(new Solution().countAndSay(i));
    }
}